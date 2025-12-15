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

//删除订单子项
@WebServlet("/DelorderitemServlet")
public class DelorderitemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String ordernumber = request.getParameter("ordernumber");

        System.out.println("删除"+id+'+'+ordernumber);

        OrderDao dao = new OrderDaoimpl();
        dao.delorderitem(id);

//        再循环计算一次价格

        List<Orderitem> orderitems = dao.updateorderitem(ordernumber);

        int totalmoney = 0;
        for ( var i =0;i<orderitems.size();i++){
            totalmoney = totalmoney+orderitems.get(i).getNumber()*Integer.parseInt(orderitems.get(i).getMoney());
        }

//        修改订单的总金额
        dao.updateordertotalmoney(totalmoney,ordernumber);

        request.setAttribute("ordernumber",ordernumber);
        request.getRequestDispatcher("FindorderitemServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}
