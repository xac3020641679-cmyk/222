package web.tjzx;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.DateRange;
import domain.Foodtj;
import domain.Orderitem;
import domain.User;
import test.UserDaotest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//月度订单统计
@WebServlet("/ydddtjServlet")
public class ydddtjServlet extends HttpServlet {
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

        SimpleDateFormat DateUtilsTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateRange thisMonth = UserDaotest.getThisMonth();
        System.out.println("当前月份的时间范围: "+DateUtilsTemp.format(thisMonth.getStart())+" - "+DateUtilsTemp.format(thisMonth.getEnd()));

        String starttime = DateUtilsTemp.format(thisMonth.getStart());
        String endtime = DateUtilsTemp.format(thisMonth.getEnd());

        Timestamp starttimein = Timestamp.valueOf(starttime);

        Timestamp endtimein = Timestamp.valueOf(endtime);

        OrderDao dao = new OrderDaoimpl();
//            ArrayList<String> name = new ArrayList<>();

        List<Orderitem> name2 = dao.findordernameweiyi2(starttimein,endtimein);

        System.out.println("查询特殊"+name2);

        ArrayList<Foodtj> Foodtj  = new ArrayList<>();



        for (var i = 0 ;i<name2.size();i++){

            Foodtj Foodtjlist = new Foodtj();
            List<Orderitem> name4 = dao.findteshu(name2.get(i).getMenuname(),name2.get(i).getMoney(),starttimein,endtimein);
            System.out.println("name4为"+name4);
            Foodtjlist.setMennuname(name2.get(i).getMenuname());
            Foodtjlist.setMoney(name2.get(i).getMoney());

            Foodtjlist.setList(name4);

            int cishu = 0;
            for (var j = 0;j<name4.size();j++){
                cishu = cishu + name4.get(j).getNumber();
            }

            Foodtjlist.setCishu(cishu);
            Foodtj.add(Foodtjlist);

        }




//            单独计算总金额
        int totalmoney = 0;
        List<Orderitem> jisuantotalmoney = dao.findrangetime(starttimein,endtimein);
        for (var i = 0;i<jisuantotalmoney.size();i++){

            totalmoney = jisuantotalmoney.get(i).getNumber()* Integer.parseInt(jisuantotalmoney.get(i).getMoney()) +totalmoney;
        }

//        当前月份
        Calendar calendar = Calendar.getInstance();
        //记得要+1
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("当前月份month = " + month);


        request.setAttribute("orderitemstj",Foodtj);
        request.setAttribute("totalmoney",totalmoney);
        request.setAttribute("month",month);
        request.getRequestDispatcher("tjzx-ydddtj.jsp").forward(request,response);



    }
}
