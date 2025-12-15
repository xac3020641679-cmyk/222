package web.glym;

import dao.OrderDao;
import dao.impl.OrderDaoimpl;
import domain.Orderitem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//修改订单子项
@WebServlet("/updateorderServlet")
public class updateorderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        String ordernumber = request.getParameter("ordernumber");
        String number = request.getParameter("number");
        System.out.println(id+'+'+ordernumber+'+'+number);

        OrderDao dao = new OrderDaoimpl();

//        先修改了某个id的数目

        dao.updateorderitemnumber(id,number);

//        再找出所有的，再次计算一次总金额
        List<Orderitem> orderitems = dao.updateorderitem(ordernumber);

        int totalmoney = 0;
        for (var i=0;i<orderitems.size();i++){
            totalmoney = totalmoney+orderitems.get(i).getNumber()*Integer.parseInt(orderitems.get(i).getMoney());
        }

//        再找出对应总订单，赋值总金额

        dao.updateordertotalmoney(totalmoney,ordernumber);

        request.setAttribute("ordernumber",ordernumber);
        request.getRequestDispatcher("FindorderitemServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
