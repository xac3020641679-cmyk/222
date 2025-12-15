package web.tjzx;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.Caiyao;
import domain.Jrzkdd;
import domain.Orderitem;
import domain.User;
import test.UserDaotest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//今日总括订单
@WebServlet("/jrzkddServlet")
public class jrzkddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        User newuser = (User) request.getSession().getAttribute("User");
        String username = newuser.getUsername();

        //       调用test中UserDaotest的getDateStartAndEnd方法
        Date date = new Date();
        Timestamp[] s = UserDaotest.getDateStartAndEnd();

        System.out.println(s[0]+"第二个"+s[1]);
        System.out.println("转化为时间错第一个"+s[0].getTime()+"第二个"+s[1].getTime());

        Timestamp todaystart = s[0];
        Timestamp todayend = s[1];

//        今日订单总括总金额
        int totalmoney = 0;

        OrderDao dao2 = new OrderDaoimpl();

        ArrayList<Jrzkdd> Jrzkddlist = new ArrayList<>();

//        根据订单子项中菜品编号和菜名字和单价去重
//        distinct的缺点是只返回去重字段

        List<Orderitem> distinctorder = dao2.distinctjrzkdd(todaystart,todayend);

        for (var i = 0;i<distinctorder.size();i++){

            Jrzkdd jrzkdd = new Jrzkdd();

            int caiyaonumber = 0;
            int thistotalmoney = 0;

//            统计去重后的菜品数量
           List<Orderitem> finddistinct= dao2.finddistinctjrzkdd(distinctorder.get(i).getMenunumber(),distinctorder.get(i).getMenuname(),distinctorder.get(i).getMoney(),todaystart,todayend);


           for (var j =0;j<finddistinct.size();j++){

               caiyaonumber = caiyaonumber + finddistinct.get(j).getNumber();


           }

           thistotalmoney = caiyaonumber * Integer.parseInt(distinctorder.get(i).getMoney()) ;

            jrzkdd.setMenunumber(distinctorder.get(i).getMenunumber());
            jrzkdd.setMenuname(distinctorder.get(i).getMenuname());
            jrzkdd.setMoney(distinctorder.get(i).getMoney());
            jrzkdd.setNumber(caiyaonumber);
            jrzkdd.setThistotalmoney(thistotalmoney);
            Jrzkddlist.add(jrzkdd);

        }

        for (var i = 0;i<Jrzkddlist.size();i++){
            totalmoney = totalmoney + Jrzkddlist.get(i).getThistotalmoney();
        }

        //        现在的时间


        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);



        request.setAttribute("Jrzkddlist",Jrzkddlist);
        request.setAttribute("username",username);
        request.setAttribute("totalmoney",totalmoney);
        request.setAttribute("nowTime",nowTime);
        request.getRequestDispatcher("tjzx-jrddzk.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
