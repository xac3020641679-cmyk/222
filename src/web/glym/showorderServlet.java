package web.glym;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.Order;
import domain.Orderitem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//修改订单的数据回显
@WebServlet("/showorderServlet")
public class showorderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String ordernumber = request.getParameter("ordernumber");

        OrderDao dao = new OrderDaoimpl();

        Orderitem order = dao.huixianorder(id);

        request.setAttribute("ordernumber",ordernumber);
        request.setAttribute("order",order);
        request.getRequestDispatcher("glym-ddupdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
