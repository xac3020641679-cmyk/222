package web.glym;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//订单总项管理
@WebServlet("/FindOrderServlet2")
public class FindOrderServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


        OrderDao dao = new OrderDaoimpl();

        List<Order> orders = dao.findallorder();

        request.setAttribute("orders",orders);
        request.getRequestDispatcher("glym-ddtoday.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
