package com.ua.sutty.filters;

import com.ua.sutty.domain.User;
import com.ua.sutty.utils.AvailableUrl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        AvailableUrl availableUrl = new AvailableUrl();
        List<String> allUrl = availableUrl.getAllUrl();
        List<String> urlForUser = availableUrl.getUrlForUser();
        List<String> urlForGuest = availableUrl.getUrlForGuest();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        User user = (User) request.getSession().getAttribute("loginedUser");

        if (!allUrl.contains(servletPath)) {
            request.getServletContext().getRequestDispatcher("/jsp/errorPage.jsp").forward(request, response);
            return;
        }

//        if (user.getLogin() == null){
//            if (servletPath.equals("/")){
//                response.sendRedirect("/");
//                return;
//            }
//            if (servletPath.equals("/home")){
//                response.sendRedirect("/login");
//                return;
//            }
//            if (servletPath.equals("/login")){
//                response.sendRedirect("/login");
//                return;
//            }
//            if (servletPath.equals("/edit")){
//                response.sendRedirect("/login");
//                return;
//            }
//            if (servletPath.equals("/add")){
//                response.sendRedirect("/login");
//                return;
//            }
//        }

        if (user == null) {
            if (!urlForGuest.contains(servletPath)) {
                response.sendRedirect("/login");
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            request.setAttribute("userLogin", user.getLogin());
            if (servletPath.equals("/login")) {
                response.sendRedirect("/home");
                return;
            }
            if (user.getRoleId() == 1) {
                filterChain.doFilter(request, response);
            } else {
                if (!urlForUser.contains(servletPath)) {
                    request.getServletContext().getRequestDispatcher("/jsp/accessDenied.jsp").forward(request, response);
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        }

//        if (user == null){
//            if (servletPath.equals("/edit") || servletPath.equals("/add") || servletPath.equals("/home") || servletPath.equals("/delete")){
//                response.sendRedirect("/login");
////                System.out.println(1);
//                return;
//            }
//            if (servletPath.equals("/")){
//                filterChain.doFilter(request, response);
//            }
//            if (servletPath.equals("/login")){
//                filterChain.doFilter(request, response);
//            }
////            filterChain.doFilter(request, response);
//        }

//        if (user == null && !servletPath.equals("/") && !servletPath.equals("/login")){
//            response.sendRedirect("/login");
//            return;
//        }

//        if (servletPath.equals("/home")){
//            response.sendRedirect("/home");
//            return;
//        }

//        if (servletPath.equals("/login")) {
//            if (user != null) {
//                response.sendRedirect("/home");
//                return;
//            }
//        }
//
//        if (servletPath.equals("/edit")) {
//            if (Objects.requireNonNull(user).getRoleId() == 1) {
//                filterChain.doFilter(request, response);
//            } else {
//                request.getServletContext().getRequestDispatcher("/jsp/accessDenied.jsp").forward(request, response);
//            }
//        }
//
//        if (servletPath.equals("/add")) {
//            if (Objects.requireNonNull(user).getRoleId() == 1) {
//                filterChain.doFilter(request, response);
//            } else {
//                request.getServletContext().getRequestDispatcher("/jsp/accessDenied.jsp").forward(request, response);
//            }
//        }
//
//        if (servletPath.equals("/delete")) {
//            if (Objects.requireNonNull(user).getRoleId() == 1) {
//                filterChain.doFilter(request, response);
//            } else {
//                request.getServletContext().getRequestDispatcher("/jsp/accessDenied.jsp").forward(request, response);
//            }
//        }

//        if (servletPath.equals("/login")) {
//            filterChain.doFilter(request, response);
////            return;
//        }

//        if (user != null) {
//            request.setAttribute("userLogin", user.getLogin());
//            filterChain.doFilter(request, response);
//        }
//
//        if (servletPath.equals("/")) {
//            filterChain.doFilter(request, response);
//
//        }


//        return;
    }

    @Override
    public void destroy() {

    }
}
