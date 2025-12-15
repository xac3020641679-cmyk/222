package web.main;

import domain.Food;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String menunumber = request.getParameter("menunumber");

        List<Food> foodlist = (List<Food>) request.getSession().getAttribute("ois");

        for (var i =0 ;i<foodlist.size();i++){
            if (foodlist.get(i).getMenunumber() == Integer.parseInt(menunumber)) {
                foodlist.remove(i);
                PrintWriter out = response.getWriter();
                out.print("<script>alert('删除成功!');" +
                        "window.location.href='maincaidanServlet'</script>" +
                        "");
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
