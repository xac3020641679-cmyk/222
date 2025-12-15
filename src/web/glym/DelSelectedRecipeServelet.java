package web.glym;

import dao.Recipe;
import service.RecipeService;
import service.impl.RecipeServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//批量删除菜谱
@WebServlet("/DelSelectedRecipeServelet")
public class DelSelectedRecipeServelet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

//        批量删除
        String[] recipeids = request.getParameterValues("mid");

        RecipeService service = new RecipeServiceimpl();

        service.delselectedrecipe(recipeids);

        response.sendRedirect("ShowrecipeServlet");
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
