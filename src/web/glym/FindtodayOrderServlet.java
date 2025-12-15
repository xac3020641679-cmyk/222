package web.glym;

import dao.CaidanDao;
import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.Order;
import domain.Orderitem;
import test.UserDaotest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//查找当天订单总项
@WebServlet("/FindtodayOrderServlet")
public class FindtodayOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
//       调用test中UserDaotest的getDateStartAndEnd方法
        java.util.Date date = new Date();
        Timestamp[] s = UserDaotest.getDateStartAndEnd();

        System.out.println(s[0]+"第二个"+s[1]);
        System.out.println("转化为时间错第一个"+s[0].getTime()+"第二个"+s[1].getTime());
        OrderDao dao = new OrderDaoimpl();

        List<Order> list = dao.findtodayordertotal();

        ArrayList<Order> todaylist = new ArrayList<>();

        for (var i =0;i<list.size();i++){
            System.out.println("第"+i+"个时间："+list.get(i));
            if (s[0].getTime()< list.get(i).getDate().getTime()){

                if (s[1].getTime()>list.get(i).getDate().getTime()){
                    System.out.println("true");
                    todaylist.add(list.get(i));
                    System.out.println(todaylist);
                }

            }
        }

        request.setAttribute("orders",todaylist);
        request.getRequestDispatcher("glym-ddtoday.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
