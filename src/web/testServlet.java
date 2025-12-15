package web;

import domain.DateRange;
import test.UserDaotest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat DateUtilsTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateRange thisMonth = UserDaotest.getThisMonth();
        System.out.println("当前月份的时间范围: "+DateUtilsTemp.format(thisMonth.getStart())+" - "+DateUtilsTemp.format(thisMonth.getEnd()));

        System.out.println("月初转换成时间戳"+thisMonth.getStart().getTime());

        System.out.println("我能过来");
//        Timestamp[] s = UserDaotest.getThisMonth();
//
//        System.out.println(s[0]+"第二个"+s[1]);
//        System.out.println("转化为时间错第一个"+s[0].getTime()+"第二个"+s[1].getTime());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
