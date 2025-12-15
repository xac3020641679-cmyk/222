package web.grzx;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.*;
import test.UserDaotest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/grydtjServlet")
public class grydtjServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        User newuser = (User) request.getSession().getAttribute("User");
        String username = newuser.getUsername();
        String phone = newuser.getPhone();

        SimpleDateFormat DateUtilsTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateRange thisMonth = UserDaotest.getThisMonth();
        System.out.println("当前月份的时间范围: "+DateUtilsTemp.format(thisMonth.getStart())+" - "+DateUtilsTemp.format(thisMonth.getEnd()));

        String starttime = DateUtilsTemp.format(thisMonth.getStart());

        Timestamp starttimein = Timestamp.valueOf(starttime);

        System.out.println("这个月的第一天时间"+starttimein);

        //        现在的时间

        Date date = new Date();

        System.out.println(date);

        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        System.out.println(nowTime);

        Timestamp OrderlistTime = Timestamp.valueOf(nowTime);

        System.out.println("现在的时间"+OrderlistTime);


        OrderDao dao = new OrderDaoimpl();
        //        因为订单子项没有加每一个菜的总价，所以创建了一个新的实体


        ArrayList<Grydtj> showmyorder  = new ArrayList<>();

//        获取个人用户名的订单信息

        List<Order> userorder= dao.finduserorder(starttimein,OrderlistTime,username);

        for (var i =0;i<userorder.size();i++){

            List<Orderitem> myorder = dao.findmyordertj(userorder.get(i).getOrdernumber());

            for (var j = 0; j< myorder.size();j++){
                Grydtj eachorder = new Grydtj();
                int thistotalmoney = 0;
                eachorder.setMenuname(myorder.get(j).getMenuname());
                eachorder.setUnit(myorder.get(j).getUnit());
                eachorder.setDate(myorder.get(j).getDate());
                eachorder.setMoney(myorder.get(j).getMoney());
                eachorder.setNumber(myorder.get(j).getNumber());

                thistotalmoney = myorder.get(j).getNumber() * Integer.parseInt(myorder.get(j).getMoney() );

                eachorder.setThistotalmoney(thistotalmoney);

                showmyorder.add(eachorder);

            }

        }

//        统计页面订单当月所有订单金额

        int totalmoney = 0;

        for (var j = 0;j<userorder.size();j++){

            totalmoney = totalmoney + userorder.get(j).getTotalmoney();

        }

        request.setAttribute("order",showmyorder);
        request.setAttribute("totalmoney" ,totalmoney);
        request.setAttribute("username",username);
        request.setAttribute("nowtime",nowTime);
        request.setAttribute("phone",phone);
        request.setAttribute("starttime",starttime);
        request.getRequestDispatcher("userpages/mygrydddtj.jsp").forward(request,response);
    }
}
