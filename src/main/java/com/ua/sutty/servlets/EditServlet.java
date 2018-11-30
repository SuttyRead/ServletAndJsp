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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JdbcUserDao jdbcUserDao = new JdbcUserDao(new DataSource().getBasicDataSourceTest());

        String id = req.getParameter("userId");

        System.out.println("Don't have id" + id);
        if (req.getParameter("successfulUpdate") == null || Integer.valueOf(req.getParameter("successfulUpdate")) != 1 ){
            if (id == null) {
                req.getServletContext().getRequestDispatcher("/jsp/errorPage.jsp").forward(req, resp);
                return;
            }
        }

        User someUser = jdbcUserDao.findById(Long.valueOf(id));
        if (someUser.getLogin() == null){
            req.getServletContext().getRequestDispatcher("/jsp/errorPage.jsp").forward(req, resp);
        }
        req.getSession().setAttribute("someUser", someUser);
        req.getServletContext().getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);
//        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("successfullUpdate", 2);
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthday = req.getParameter("birthday");
        String role = req.getParameter("role");
        User user = new User(Long.valueOf(id), login, password, email, firstName, lastName, Date.valueOf(birthday), Long.valueOf(role));
        JdbcUserDao jdbcUserDao = new JdbcUserDao(new DataSource().getBasicDataSourceTest());
        jdbcUserDao.update(user);
        req.setAttribute("someUser", user);
        req.setAttribute("successfullUpdate", 1);
        System.out.println("Succ");
        req.getServletContext().getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);

//        String id = req.getParameter("id");
//        User someUser = jdbcUserDao.findById(Long.valueOf(id));
//        req.getSession().setAttribute("someUser", someUser);
//        req.getServletContext().getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);

    }
}
