package web;


import dao.FindUserDao;
import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/*
 * 用户注册
 */

@WebServlet("/registerServerlet")
public class registerServerlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String username= request.getParameter("username");
        String wisdom = request.getParameter("wisdom");
        Map<String,String[]> map = request.getParameterMap();
        System.out.println("注册的用户名为"+username);
        System.out.println("身份为"+wisdom);
        domain.User registeruser = new domain.User();
        registeruser.setUsername(username);

        registeruser.setWisdom(wisdom);

//        调用Userdao的login方法
        FindUserDao dao = new FindUserDao();
        domain.User Ruser = dao.finduser(registeruser);
        System.out.println("填入值："+registeruser);
        System.out.println("注册响应值"+Ruser);

        if (Ruser == null){

            System.out.println("正在前往注册");
            PrintWriter out = response.getWriter();
            domain.User user = new domain.User();

            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserListDao userListDao = new UserListDaoimpl();

            userListDao.adduser(user);

            request.getSession().setAttribute("User",user);
            response.sendRedirect("./main.jsp");

        }else {

            System.out.println("注册失败");
            JOptionPane.showMessageDialog(null, "用户已存在!");
            request.getRequestDispatcher("./register.jsp").forward(request,response);
        }



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
