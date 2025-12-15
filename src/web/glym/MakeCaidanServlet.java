package web.glym;

import dao.impl.Recipeimpl;
import domain.Caidan;
import domain.Recipe;
import domain.User;
import service.RecipeService;
import service.impl.RecipeServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//菜谱页面形成菜单
@WebServlet("/MakeCaidanServlet")
public class MakeCaidanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        int status = 0;

        User operator = (User) request.getSession().getAttribute("User");
        String[] mids = request.getParameterValues("mid");


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

        String ordernumber = sdf.format(new Date())+makeUUID(6).toUpperCase();



        System.out.println(ordernumber);

//        时间

        Date date = new Date();

        System.out.println(date);

        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        System.out.println(nowTime);

        Timestamp OrderlistTime = Timestamp.valueOf(nowTime);

        System.out.println(OrderlistTime);



        if (mids !=null && mids.length > 0){
            for (int i = 0; i<mids.length; i++){

                RecipeService service = new RecipeServiceimpl();
                String id = mids[i];
                Recipe menu = service.findrecipe(id);

                service.xcmenu(ordernumber,OrderlistTime,menu);

            }

        }

        Caidan caidan = new Caidan();

        caidan.setOrdernumber(ordernumber);
        caidan.setDate(OrderlistTime);
        caidan.setOperator(operator.getUsername());
        caidan.setStatus(status);

        RecipeService service = new RecipeServiceimpl();
        service.makecaidan(caidan);

        PrintWriter out = response.getWriter();
        out.print("<script>alert('菜单形成成功!');" +
                "window.location.href='ShowrecipeServlet'</script>" +
                "");





    }
    //    生成菜单号随机数
    private String makeUUID(int i) {
        return UUID.randomUUID().toString().replace("-","").substring(0,i);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
