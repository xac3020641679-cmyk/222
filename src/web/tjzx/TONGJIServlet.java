package web.tjzx;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.Foodtj;
import domain.Order;
import domain.Orderitem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet("/TONGJIServlet")
public class TONGJIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String start = request.getParameter("start");
        String end = request.getParameter("end");
        System.out.println("start"+start);
        System.out.println("end"+end);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US);


        LocalDateTime localDate1 = LocalDateTime.parse(start, formatter);
        LocalDateTime localDate2 = LocalDateTime.parse(end, formatter);

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDate1));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDate2));

        Timestamp starttime = Timestamp.valueOf(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDate1));
        Timestamp endtime = Timestamp.valueOf(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDate2));

        System.out.println("开始时间"+starttime);
        System.out.println("结束时间"+endtime);

        if ( starttime.getTime() >= endtime.getTime()){

            PrintWriter out = response.getWriter();
            out.print("<script>alert('开始时间不能大于结束时间!');" +
                    "window.location.href='tjzx-maintj.jsp'</script>" +
                    "");
        }else {

            OrderDao dao = new OrderDaoimpl();
//            ArrayList<String> name = new ArrayList<>();

            List<Orderitem> name2 = dao.findordernameweiyi2(starttime,endtime);

            System.out.println("查询特殊"+name2);

           ArrayList<Foodtj> Foodtj  = new ArrayList<>();



           for (var i = 0 ;i<name2.size();i++){

               Foodtj Foodtjlist = new Foodtj();
               List<Orderitem> name4 = dao.findteshu(name2.get(i).getMenuname(),name2.get(i).getMoney(),starttime,endtime);
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
            List<Orderitem> jisuantotalmoney = dao.findrangetime(starttime,endtime);
            for (var i = 0;i<jisuantotalmoney.size();i++){

                totalmoney = jisuantotalmoney.get(i).getNumber()* Integer.parseInt(jisuantotalmoney.get(i).getMoney()) +totalmoney;
            }



            request.setAttribute("orderitemstj",Foodtj);
            request.setAttribute("totalmoney",totalmoney);
            request.setAttribute("starttime",starttime);
            request.setAttribute("endtime",endtime);
            request.getRequestDispatcher("tjzx-maintj.jsp").forward(request,response);


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
