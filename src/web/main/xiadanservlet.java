package web.main;

import dao.MainDao;
import dao.impl.MainDaoimpl;
import domain.Food;
import domain.Order;
import domain.Orderitem;
import domain.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/xiadanservlet")
public class xiadanservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String[] number = request.getParameterValues("number");
        System.out.println(Arrays.toString(number));

        List<Food> foodlist = (List<Food>) request.getSession().getAttribute("ois");
        User operator = (User) request.getSession().getAttribute("User");

        if (foodlist.size() == 0){
            PrintWriter out = response.getWriter();
            out.print("<script>alert('下单不可为空!');" +
                    "window.location.href='maincaidanServlet'</script>" +
                    "");
        }else {


//        订单号
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

            String ordernumber = sdf.format(new Date())+makeUUID(6).toUpperCase();

            System.out.println(ordernumber);

//        时间

            Date date = new Date();

            System.out.println(date);

            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

            System.out.println(nowTime);

            Timestamp OrderlistTime = Timestamp.valueOf(nowTime);

            System.out.println(OrderlistTime);

//        计算总价格
            int totalmoney = 0;
            for (var i =0;i<foodlist.size();i++){

                totalmoney = totalmoney + Integer.parseInt(foodlist.get(i).getMoney())*Integer.parseInt(number[i])  ;
            }

            System.out.println("总价格"+totalmoney);
//        订单总项
            MainDao dao = new MainDaoimpl();

            dao.addtotalorder(operator.getUsername(),operator.getName(),totalmoney,OrderlistTime,ordernumber);

//        订单子项
            for (var i =0;i<foodlist.size();i++){
                Orderitem orderitem = new Orderitem();
                orderitem.setOrdernumber(ordernumber);
                orderitem.setMenunumber(foodlist.get(i).getMenunumber());
                orderitem.setMenuname(foodlist.get(i).getMenuname());
                orderitem.setUnit(foodlist.get(i).getUnit());
                orderitem.setMoney(foodlist.get(i).getMoney());
                orderitem.setNumber(Integer.parseInt(number[i]));
                orderitem.setDate(OrderlistTime);
                orderitem.setRemarks(foodlist.get(i).getRemarks());
                MainDao dao2 = new MainDaoimpl();
                dao2.addorderitem(orderitem);
            }

            request.getSession().removeAttribute("ois");

            PrintWriter out = response.getWriter();
            out.print("<script>alert('下单成功!');" +
                    "window.location.href='maincaidanServlet'</script>" +
                    "");



        }


    }

    //    生成订单号随机数
    private String makeUUID(int i) {
        return UUID.randomUUID().toString().replace("-","").substring(0,i);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
