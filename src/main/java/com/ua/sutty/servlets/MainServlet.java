package com.ua.sutty.servlets;

import com.ua.sutty.domain.User;
import com.ua.sutty.utils.LoadProperties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
//        LoadProperties loadProperties = new LoadProperties();
//        loadProperties.loadProperties();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("loginedUser");
        if (user == null){
            req.setAttribute("login", "Guest");
        }else {
            req.setAttribute("login", user.getLogin());
        }
        req.getServletContext().getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }

}
