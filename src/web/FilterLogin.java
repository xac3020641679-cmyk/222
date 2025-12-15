
package web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//非法拦截，未登录拦截
//静态资源，无需登录页面都要放行,指定操作，登录状态（session）


@WebFilter("/*")
public class FilterLogin implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        System.out.println(url);
        Object user =request.getSession().getAttribute("User");
        String or = (String) request.getSession().getAttribute("or");

        if (url.contains("/login.html")){
            filterChain.doFilter(request,response);
            return;
        }

        if (url.contains("/js") || url.contains("/imgs") || url.contains("/css")){
            filterChain.doFilter(request,response);
            System.out.println("我的静态资源放行了");
            return;
        }

        if (url.contains("/loginServlet") || url.contains("/register.jsp") || url.contains("/register")){
            filterChain.doFilter(request,response);
            return;
        }



        if (user != null){
            filterChain.doFilter(request,response);
            return;
        }


        System.out.println("被拦截了");
        response.sendRedirect("login.html");




    }

    @Override
    public void destroy() {

    }
}


