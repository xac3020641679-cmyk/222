package web.main;

import dao.MainDao;
import dao.impl.MainDaoimpl;
import domain.Order;
import domain.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindmyorderServlet")
public class FindmyorderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        User operator = (User) request.getSession().getAttribute("User");

        MainDao dao = new MainDaoimpl();

        List<Order> orders = dao.findmyorder(operator.getUsername());

        request.setAttribute("orders",orders);
        request.getRequestDispatcher("userpages/myorder.jsp").forward(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
