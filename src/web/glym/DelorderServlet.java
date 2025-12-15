package web.glym;

import dao.MainDao;
import dao.OrderDao;
import dao.impl.MainDaoimpl;
import dao.impl.OrderDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除订单
@WebServlet("/DelorderServlet")
public class DelorderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String ordernumber = request.getParameter("ordernumber");

        OrderDao dao = new OrderDaoimpl();

        dao.delorder(ordernumber);

//        级联删除
        dao.delitemorder(ordernumber);

        response.sendRedirect("FindOrderServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
