package com.ua.sutty.servlets;

import com.ua.sutty.repository.impl.JdbcUserDao;
import com.ua.sutty.utils.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("successfullDelete", 2);
        JdbcUserDao jdbcUserDao = new JdbcUserDao(new DataSource().getBasicDataSourceTest());

        String id = req.getParameter("userIdForDelete");

        System.out.println("Don't have id" + id);
        if (req.getParameter("successfullDelete") == null || Integer.valueOf(req.getParameter("successfullDelete")) != 1 ) {
            if (id == null) {
                req.getServletContext().getRequestDispatcher("/jsp/errorPage.jsp").forward(req, resp);
                return;
            }
        }
        jdbcUserDao.remove(jdbcUserDao.findById(Long.valueOf(id)));
        req.getSession().setAttribute("successfullDelete", 1);
//        req.setAttribute("successfullDelete", 1);
        req.getSession().setAttribute("users", jdbcUserDao.findAll());
//        req.getServletContext().getRequestDispatcher("/jsp/admin-home.jsp").forward(req, resp);
        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
