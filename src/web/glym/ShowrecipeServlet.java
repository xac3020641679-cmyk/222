package web.glym;

import dao.Recipe;
import dao.impl.Recipeimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//菜谱页面显示
@WebServlet("/ShowrecipeServlet")
public class ShowrecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //       调用service完成指定操作查询

        Recipe dao = new Recipeimpl();

        List<domain.Recipe> recipes = dao.finAllRecipe();

//        将List存入request域
        request.setAttribute("recipe",recipes);
        request.getRequestDispatcher("glym-cpgl.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
