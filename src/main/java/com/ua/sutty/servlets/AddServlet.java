package com.ua.sutty.servlets;

import com.ua.sutty.domain.User;
import com.ua.sutty.repository.impl.JdbcUserDao;
import com.ua.sutty.utils.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("successfullAdd", 2);
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthday = req.getParameter("birthday");
        String role = req.getParameter("role");

        JdbcUserDao jdbcUserDao = new JdbcUserDao(new DataSource().getBasicDataSourceTest());
//        User byLogin = jdbcUserDao.findByLogin(login);
//        System.out.println(byLogin);
        System.out.println("ExistLogin ==");
        System.out.println(req.getAttribute("existsLogin"));
        if (jdbcUserDao.findByLogin(login).getLogin() != null){
            req.setAttribute("existLogin", 1);
            req.getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
            return;
        }else {
            req.setAttribute("existLogin", 2);
        }
        if (jdbcUserDao.findByEmail(email).getEmail() != null){
            req.setAttribute("existEmail", 1);
            req.getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
            return;
        }else {
            req.setAttribute("existEmail", 2);
        }
        User user = new User(login, password, email, firstName, lastName, Date.valueOf(birthday), Long.valueOf(role));
        jdbcUserDao.create(user);
        req.setAttribute("successfullAdd", 1);
        doGet(req, resp);
    }

}
