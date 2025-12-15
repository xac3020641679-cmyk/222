package web.glym;

import domain.Recipe;
import service.RecipeService;
import service.impl.RecipeServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//菜谱修改时候的回显信息
@WebServlet("/FindRecipeServlet")
public class FindRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        RecipeService service = new RecipeServiceimpl();

        Recipe Recipe =  service.FindRecipe(id);

        request.setAttribute("Recipe",Recipe);

        request.getRequestDispatcher("glym-cpxg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   this.doPost(request,response);
    }
}
