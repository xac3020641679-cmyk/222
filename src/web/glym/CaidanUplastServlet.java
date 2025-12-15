package web.glym;

import domain.Caidan;
import org.apache.commons.beanutils.BeanUtils;
import service.CaidanService;
import service.impl.CaidanServiceimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//确认是否上传为最终菜单
@WebServlet("/CaidanUplastServlet")
public class CaidanUplastServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String,String[]> map = request.getParameterMap();
        Caidan caidan = new Caidan();
        try {
            BeanUtils.populate(caidan,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        CaidanService service = new CaidanServiceimpl();
        service.CaidanUp(caidan);

        response.getWriter().write("<script language=javascript>alert('菜单上传成功！！');window.location='FindCaidanServlet'</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
