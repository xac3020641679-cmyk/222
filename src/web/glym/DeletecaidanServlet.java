package web.glym;

import dao.CaidanDao;
import dao.impl.CaidanDaoimpl;
import domain.Caidan;
import service.CaidanService;
import service.impl.CaidanServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除菜单总项
@WebServlet("/DeletecaidanServlet")
public class DeletecaidanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ordernumber = request.getParameter("ordernumber");

        CaidanDao dao = new CaidanDaoimpl();

        dao.Deletecaidan(ordernumber);

        //        跳转MenuListServlet
        response.sendRedirect("FindCaidanServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
