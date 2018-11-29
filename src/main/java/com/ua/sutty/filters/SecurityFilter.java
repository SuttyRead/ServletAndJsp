package com.ua.sutty.filters;

import com.ua.sutty.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        User user = (User) request.getSession().getAttribute("loginedUser");

        if (user == null && !servletPath.equals("/") && !servletPath.equals("/login")){
            response.sendRedirect("/login");
            return;
        }

//        if (servletPath.equals("/home")){
//            response.sendRedirect("/home");
//            return;
//        }

        if (servletPath.equals("/login")){
            if (user != null){
                response.sendRedirect("/home");
                return;
            }
        }

        System.out.println(servletPath);
        if (servletPath.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (servletPath.equals("/")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (user != null){
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
