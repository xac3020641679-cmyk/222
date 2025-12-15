package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDao;
import dao.impl.OrderDaoJdbcImpl;
import domain.OrderForm;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 员工提交订单接口（POST）
 * 接收 JSON 格式的 OrderForm（除 id、orderTime、totalPrice 外）
 * 返回 JSON { "orderId": 123 } 或 { "error": "..." }
 */
@WebServlet("/order/submit")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        OrderDao orderDao = new OrderDaoJdbcImpl();
        orderService = new OrderService(orderDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrderForm order = mapper.readValue(req.getInputStream(), OrderForm.class);
            Long id = orderService.submitOrder(order);
            resp.setStatus(200);
            resp.setContentType("application/json;charset=UTF-8");
            mapper.writeValue(resp.getOutputStream(), java.util.Collections.singletonMap("orderId", id));
        } catch (IllegalStateException ise) {
            resp.setStatus(400);
            resp.setContentType("application/json;charset=UTF-8");
            mapper.writeValue(resp.getOutputStream(), java.util.Collections.singletonMap("error", ise.getMessage()));
        } catch (Exception e) {
            resp.setStatus(500);
            resp.setContentType("application/json;charset=UTF-8");
            mapper.writeValue(resp.getOutputStream(), java.util.Collections.singletonMap("error", "服务器错误"));
            e.printStackTrace();
        }
    }
}
