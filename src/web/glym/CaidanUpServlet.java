package web.glym;

import dao.FindUpCaidanDao;
import domain.Caidan;
import service.CaidanService;
import service.impl.CaidanServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//判断是否已经有在线的菜单
@WebServlet("/CaidanUpServlet")
public class CaidanUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String ordernumber = request.getParameter("ordernumber");

//        判断是否已有在线上的菜单
        int status = 1;

        Caidan upcaidan = new Caidan();
        upcaidan.setStatus(status);


//        调用Userdao的login方法
        FindUpCaidanDao dao = new FindUpCaidanDao();
        Caidan ISupcaidan = dao.findupcaidan(upcaidan);

        System.out.println(ISupcaidan);
        System.out.println("我进到了第一个");

        if (ISupcaidan == null){
            System.out.println("我进到了第二个");

            CaidanService service = new CaidanServiceimpl();

            Caidan caidan = service.findspecific(ordernumber);

            request.setAttribute("caidan",caidan);

            request.getRequestDispatcher("glym-Isupcaidan.jsp").forward(request,response);

        }else {
            System.out.println("上传菜单失败！！");
            response.getWriter().write("<script language=javascript>alert('已有上线菜单,请下线已有的菜单后再上线此菜单！');window.location='FindCaidanServlet'</script>");




        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
