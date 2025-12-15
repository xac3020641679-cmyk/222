package web;


import dao.UserDao;
import domain.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 登录操作
 */
@WebServlet("/loginServlet")
public class LoginServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("我的账号"+username);
        System.out.println("我的密码"+password);
//        封装user对象
        domain.User loginuser= new domain.User();

        loginuser.setUsername(username);
        loginuser.setPassword(password);


//        调用Userdao的login方法
        UserDao dao = new UserDao();
        domain.User user = dao.login(loginuser);

        System.out.println("验证前的user"+user);
        if (user == null){

            System.out.println("登录失败");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('用户名或密码错误!');" +
                    "window.location.href='./login.html'</script>" +
                    "");
        }else {
            System.out.println("登录成功");
            request.setAttribute("User",user);
            request.getSession().setAttribute("User",user);
            response.sendRedirect("maincaidanServlet");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
