package web.pcygl;

import dao.CaidanDao;
import dao.OrderDao;
import dao.impl.CaidanDaoimpl;
import dao.impl.OrderDaoimpl;
import domain.*;
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

//厨师长当天菜肴统计
@WebServlet("/pcyglmainServlet")
public class pcyglmainServlet extends HttpServlet {
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

        OrderDao dao2 = new OrderDaoimpl();

        ArrayList<Caiyao> namelist = new ArrayList<>();

//        根据订单子项中菜品编号和菜名字去重
//        distinct的缺点是只返回去重字段
//        一个坏处是，烹饪说明若加上去重字段，会出现重复现象
        List<Orderitem> distinctorder = dao2.distinctorder(todaystart,todayend);

        for (var i = 0;i<distinctorder.size();i++){

            Caiyao caiyao = new Caiyao();

            int caiyaonumber = 0;



//            统计去重后的菜品数量
           List<Orderitem> finddistinct= dao2.finddistinct(distinctorder.get(i).getMenunumber(),distinctorder.get(i).getMenuname(),todaystart,todayend);


           for (var j =0;j<finddistinct.size();j++){

               caiyaonumber = caiyaonumber + finddistinct.get(j).getNumber();


           }
           String remarks = finddistinct.get(finddistinct.size()-1).getRemarks();

           caiyao.setMenunumber(distinctorder.get(i).getMenunumber());
           caiyao.setMennuname(distinctorder.get(i).getMenuname());
//           烹饪说明取最新的那一个订单号的烹饪说明
//            为了防止菜单的烹饪说明的修改，我们统计给厨师长的烹饪说明要指定最新订单的烹饪说明
//            并未将菜品编号从菜谱或者菜单里面获取烹饪说明
           caiyao.setRemarks(remarks);
           caiyao.setNumber(caiyaonumber);

            namelist.add(caiyao);

        }


        request.setAttribute("namelist2",namelist);
        System.out.println(namelist);
        System.out.println( request.getSession().getAttribute("namelist2"));

        request.getRequestDispatcher("pcygl-dtcytj.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
