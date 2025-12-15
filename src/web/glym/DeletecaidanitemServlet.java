package web.glym;

import dao.CaidanDao;
import dao.impl.CaidanDaoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除菜单中子项
@WebServlet("/DeletecaidanitemServlet")
public class DeletecaidanitemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ordernumber = request.getParameter("ordernumber");

        CaidanDao dao = new CaidanDaoimpl();
        dao.delcaidanitem(id,ordernumber);

        request.getRequestDispatcher("FindcaidanlistServlet?ordernumber="+ordernumber).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
