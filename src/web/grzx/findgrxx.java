package web.grzx;

import dao.FindUserDao;
import domain.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findgrxx")
public class findgrxx extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("回显个人信息");

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


        User newuser = (User) request.getSession().getAttribute("User");
        String username = newuser.getUsername();
        System.out.println(username);


        User registeruser = new User();
        registeruser.setUsername(username);


        FindUserDao dao = new FindUserDao();
        User user = dao.finduser(registeruser);

        request.setAttribute("user",user);
        request.getRequestDispatcher("grzx-xgxx.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
