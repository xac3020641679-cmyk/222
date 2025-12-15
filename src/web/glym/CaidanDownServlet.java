package web.glym;

import service.CaidanService;
import service.impl.CaidanServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//下线已在线的菜单
@WebServlet("/CaidanDownServlet")
public class CaidanDownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String ordernumber = request.getParameter("ordernumber");

        CaidanService service = new CaidanServiceimpl();

        service.upcaidanto(ordernumber);

        response.sendRedirect("FindCaidanServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
