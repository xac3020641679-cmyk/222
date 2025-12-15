package web.main;

import dao.MainDao;
import dao.impl.MainDaoimpl;
import domain.Caidan;
import domain.Caidanlist;
import domain.Food;
import domain.Recipe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/maincaidanServlet")
public class maincaidanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        List<Food> foodlist2 = (List<Food>) request.getSession().getAttribute("ois");
        MainDao dao = new MainDaoimpl();

        Caidan one = dao.findstatus0();

        String ordernumber = one.getOrdernumber();

        List<Caidanlist> caidanlist = dao.findupcaidan(ordernumber);

        System.out.println("我是重载时候的："+foodlist2);
        System.out.println("参考的："+caidanlist);
        request.setAttribute("foodlist2",foodlist2);
        request.setAttribute("caidanlist",caidanlist);

        request.getRequestDispatcher("main.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
