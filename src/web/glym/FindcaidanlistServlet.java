package web.glym;

import domain.Caidanlist;
import service.CaidanService;
import service.impl.CaidanServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//菜单子项页面
@WebServlet("/FindcaidanlistServlet")
public class FindcaidanlistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ordernumber = request.getParameter("ordernumber");

        CaidanService service = new CaidanServiceimpl();

        List<Caidanlist> caidanlist = service.findcaidanlist(ordernumber);


        request.setAttribute("caidanlist",caidanlist);
        request.setAttribute("ordernumber",ordernumber);

        request.getRequestDispatcher("glym-cdlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
