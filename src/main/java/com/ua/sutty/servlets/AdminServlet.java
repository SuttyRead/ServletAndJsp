package com.ua.sutty.servlets;

import com.ua.sutty.domain.Role;
import com.ua.sutty.domain.User;
import com.ua.sutty.repository.impl.JdbcUserDao;
import com.ua.sutty.tag.PrintUsers;
import com.ua.sutty.utils.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginedUser = (User) req.getSession().getAttribute("loginedUser");
        req.setAttribute("login", loginedUser.getLogin());
        System.out.println(loginedUser);
        JdbcUserDao jdbcUserDao = new JdbcUserDao(new DataSource().getBasicDataSourceTest());
        List<Role> roles = new ArrayList<>();
        Role role1 = new Role(1L, "ADMIN");
        Role role2 = new Role(2L, "USER");
        roles.add(role1);
        roles.add(role2);
        req.setAttribute("roles", roles);
        req.setAttribute("users", jdbcUserDao.findAll());
//        PrintUsers printUsers = new PrintUsers();
//        printUsers.setUsers(jdbcUserDao.findAll());
        System.out.println(jdbcUserDao.findAll());
        if (loginedUser.getRoleId() == 1){
            req.getServletContext().getRequestDispatcher("/jsp/admin-home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
