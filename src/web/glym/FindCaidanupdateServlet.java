package web.glym;

import dao.CaidanDao;
import dao.impl.CaidanDaoimpl;
import domain.Caidanlist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//修改时候回显信息
@WebServlet("/FindCaidanupdateServlet")
public class FindCaidanupdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ordernumber = request.getParameter("ordernumber");

        CaidanDao dao = new CaidanDaoimpl();
        Caidanlist caidanitem = dao.findcaidanitem(id);

        request.setAttribute("ordernumber",ordernumber);
        request.setAttribute("caidanitem",caidanitem);
        request.getRequestDispatcher("glym-cdlistupdate.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
