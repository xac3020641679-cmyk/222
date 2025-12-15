package web.glym;

import dao.Recipe;
import dao.impl.Recipeimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除菜谱
@WebServlet("/DeleteRecipeServlet")
public class DeleteRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取id
        String id = request.getParameter("id");
        Recipe dao = new Recipeimpl();
        dao.delrecipe(id);

        //        跳转MenuListServlet
        response.sendRedirect("ShowrecipeServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
