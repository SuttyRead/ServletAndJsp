package com.ua.sutty.servlets;

import com.ua.sutty.domain.User;
import com.ua.sutty.repository.impl.JdbcUserDao;
import com.ua.sutty.utils.DataSource;
import com.ua.sutty.utils.LoadProperties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        System.out.println(login);
        String password = req.getParameter("password");
        System.out.println(password);
        LoadProperties loadProperties = new LoadProperties();
        loadProperties.loadProperties();
        JdbcUserDao jdbcUserDao = new JdbcUserDao(new DataSource().getBasicDataSourceTest());
        User user = jdbcUserDao.findByLogin(login);
        System.out.println(user);
        System.out.println(1);
        if (user.getLogin() == null) {
            req.setAttribute("errorMessage", "incorrect");
            doGet(req, resp);
            return;
        }
        if (user.getPassword().equals(password)) {
            HttpSession session = req.getSession();
//            req.setAttribute("userLogin", user.getLogin());
            session.setAttribute("loginedUser", user);
            System.out.println(req.getSession().getAttribute("loginedUser"));
            resp.sendRedirect("/home");
        }else {
            req.setAttribute("errorMessage", "incorrect");
            doGet(req, resp);
        }

//        if (user.getRoleId() == 1) {
//            resp.sendRedirect("/admin");
//        }
//        if (user.getRoleId() == 2) {
//            resp.sendRedirect("/user");
//        }
    }

}
