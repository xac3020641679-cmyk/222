package web.pcygl;

import dao.OrderDao;
import dao.UserListDao;
import dao.impl.OrderDaoimpl;
import dao.impl.UserListDaoimpl;
import domain.Order;
import domain.Orderitem;
import domain.Orderitem2;
import domain.User;
import test.UserDaotest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//配餐员今日批量订单
@WebServlet("/pcytodayServlet")
public class pcytodayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //       调用test中UserDaotest的getDateStartAndEnd方法
        java.util.Date date = new Date();
        Timestamp[] s = UserDaotest.getDateStartAndEnd();

        System.out.println(s[0]+"第二个"+s[1]);
        System.out.println("转化为时间错第一个"+s[0].getTime()+"第二个"+s[1].getTime());

        Timestamp todaystart = s[0];
        Timestamp todayend = s[1];

        OrderDao dao = new OrderDaoimpl();

        List<Orderitem>  order= dao.findpcytodayorder(todaystart,todayend);

        ArrayList<Orderitem2> todayorder = new ArrayList<>();

        for (var i = 0;i<order.size();i++){
            Orderitem2 orderitem2 = new Orderitem2();
            int thistotalmoney = 0;

            thistotalmoney = order.get(i).getNumber()* Integer.parseInt(order.get(i).getMoney());

//            通过订单子项获取订单总项的下单用户名
            UserListDao dao1 = new UserListDaoimpl();
            Order order1 = dao1.findusername(order.get(i).getOrdernumber());


//            通过下单用户名找到对应的手机号
            User user = dao1.findmyphone(order1.getUsername());


            orderitem2.setId(order.get(i).getId());
            orderitem2.setMenunumber(order.get(i).getMenunumber());
            orderitem2.setMenuname(order.get(i).getMenuname());
            orderitem2.setOrdernumber(order.get(i).getOrdernumber());
            orderitem2.setUnit(order.get(i).getUnit());
            orderitem2.setRemarks(order.get(i).getRemarks());
            orderitem2.setNumber(order.get(i).getNumber());
            orderitem2.setMoney(order.get(i).getMoney());
            orderitem2.setDate(order.get(i).getDate());
            orderitem2.setThistotalmoney(thistotalmoney);
            orderitem2.setOperator(order1.getUsername());
            orderitem2.setPhone(user.getPhone());
            todayorder.add(orderitem2);

        }

        request.setAttribute("todayorder",todayorder);
        request.getRequestDispatcher("glym-ddtoday.jsp").forward(request,response);


    }
}
