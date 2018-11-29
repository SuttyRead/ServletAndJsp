package com.ua.sutty.servlets;

import com.ua.sutty.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginedUser = (User) req.getSession().getAttribute("loginedUser");
        System.out.println(loginedUser.getLogin());
        req.setAttribute("login", loginedUser.getLogin());
        if (loginedUser.getRoleId() == 1) {
            req.getServletContext().getRequestDispatcher("/jsp/admin-home.jsp").forward(req, resp);
        }
        if (loginedUser.getRoleId() == 2) {
            req.getServletContext().getRequestDispatcher("/jsp/user-home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
