package web.tjzx;

import dao.UserDao;
import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.Order;
import domain.User;
import domain.Usertj;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UsertjServlet")
public class UsertjServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        ArrayList<Usertj> usertj = new ArrayList<>();
        UserListDao dao = new UserListDaoimpl();


//        查找所有用户
        List<User> users = dao.findtjuser();

        for (var i = 0;i<users.size();i++){

            Usertj usertjs = new Usertj();
            usertjs.setUsername(users.get(i).getUsername());
            usertjs.setName(users.get(i).getName());
            usertjs.setPhone(users.get(i).getPhone());
            usertjs.setCishu(0);
            usertjs.setTotalmoney(0);

            usertj.add(usertjs);
        }

        for (var i = 0;i<usertj.size();i++){

            List<Order> orders = dao.findorderstj(usertj.get(i).getUsername());

            int cishu = orders.size();
            int totalmoney = 0;

            for (var j = 0 ;j<orders.size();j++){
                totalmoney = totalmoney + orders.get(j).getTotalmoney();
            }

            usertj.get(i).setCishu(cishu);
            usertj.get(i).setTotalmoney(totalmoney);

        }

        request.setAttribute("usertj",usertj);
        request.getRequestDispatcher("tjzx-yhtj.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
