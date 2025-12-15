package web.glym;

import dao.MainDao;
import dao.impl.MainDaoimpl;
import domain.Orderitem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//订单子项显示
@WebServlet("/FindorderitemServlet")
public class FindorderitemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String ordernumber = request.getParameter("ordernumber");

        MainDao dao =new MainDaoimpl();

        List<Orderitem> orderitems = dao.findorderitems(ordernumber);

        request.setAttribute("orderitems",orderitems);
        request.getRequestDispatcher("glym-ddlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
