package web.glym;

import domain.Caidan;
import service.CaidanService;
import service.impl.CaidanServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//跳转菜单管理页面//菜单总项页面
@WebServlet("/FindCaidanServlet")
public class FindCaidanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //       调用service完成指定操作查询
        CaidanService service = new CaidanServiceimpl();
        List<Caidan> caidanlist = service.findcaidan();

//        将List存入request域
        request.setAttribute("caidanlist",caidanlist);
        request.getRequestDispatcher("glym-cdgl.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
