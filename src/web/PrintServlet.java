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
import java.util.List;

/**
 * 打印配餐与总括订单（GET）
 * 例如： /print/today?type=blanket 或 /print/today?type=batch
 * 简单返回 text/plain 供打印（可改为 HTML/PDF）
 */
@WebServlet("/print/today")
public class PrintServlet extends HttpServlet {
    private OrderService orderService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        OrderDao orderDao = new OrderDaoJdbcImpl();
        orderService = new OrderService(orderDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        try {
            List<OrderForm> orders = orderService.getTodayOrders();
            resp.setContentType("text/plain;charset=UTF-8");
            StringBuilder out = new StringBuilder();
            if ("blanket".equalsIgnoreCase(type)) {
                out.append("总括订单（示意）\n");
                java.util.Map<String, Integer> agg = new java.util.HashMap<>();
                orders.forEach(o -> {
                    if (o.getLines() != null) {
                        o.getLines().forEach(l -> {
                            agg.put(l.getName(), agg.getOrDefault(l.getName(), 0) + l.getQuantity());
                        });
                    }
                });
                agg.forEach((name, qty) -> out.append(String.format("%s \t %d\n", name, qty)));
            } else {
                for (OrderForm o : orders) {
                    out.append(String.format("员工：%s\t联系电话：%s\n工位信息：%s\n", o.getUserName(), o.getPhone(), o.getSeatInfo()));
                    out.append("菜名\t单位\t分量\n");
                    if (o.getLines() != null) {
                        o.getLines().forEach(l -> out.append(String.format("%s\t%s\t%d\n", l.getName(), l.getUnit(), l.getQuantity())));
                    }
                    out.append("\n送餐员：_______    打印时间：" + java.time.LocalDateTime.now() + "\n");
                    out.append("-----------------------------------\n");
                }
            }
            resp.getWriter().write(out.toString());
        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write("打印失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}