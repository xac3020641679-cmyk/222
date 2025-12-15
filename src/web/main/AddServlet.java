package web.main;

import dao.MainDao;
import dao.impl.MainDaoimpl;
import domain.Caidanlist;
import domain.Food;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        List<Food> foodlist = (List<Food>) request.getSession().getAttribute("ois");

        if (foodlist == null){
            foodlist = new ArrayList<>();
            request.getSession().setAttribute("ois",foodlist);

        }
        MainDao dao = new MainDaoimpl();

        Caidanlist caidanlist = dao.addgouwuche(id);
        System.out.println("加入购物车:"+caidanlist);
        Food  food = new Food();
        food.setMenunumber(caidanlist.getMenunumber());
        food.setMenuname(caidanlist.getMenuname());
        food.setMenupicture(caidanlist.getMenupicture());
        food.setKind(caidanlist.getKind());
        food.setUnit(caidanlist.getUnit());
        food.setMoney(caidanlist.getMoney());
        food.setRemarks(caidanlist.getRemarks());
        food.setNumber(1);

        var flat = 1;
        for (var i =0 ;i<foodlist.size();i++){

            if (foodlist.get(i).getMenunumber() == food.getMenunumber()) {
                flat = 0;
            }
        }
        if (flat == 0){
            PrintWriter out = response.getWriter();
            out.print("<script>alert('已有重复!');" +
                    "window.location.href='maincaidanServlet'</script>" +
                    "");

        }else {
            foodlist.add(food);

            request.getSession().setAttribute("ois",foodlist);

            System.out.println("缓存中的："+foodlist);
            request.setAttribute("foodlist",foodlist);
            request.getRequestDispatcher("maincaidanServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
