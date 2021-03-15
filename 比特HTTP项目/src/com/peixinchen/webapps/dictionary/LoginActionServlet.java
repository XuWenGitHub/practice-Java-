package com.peixinchen.webapps.dictionary;

import com.peixinchen.standard.ServletException;
import com.peixinchen.standard.http.HttpServlet;
import com.peixinchen.standard.http.HttpServletRequest;
import com.peixinchen.standard.http.HttpServletResponse;
import com.peixinchen.standard.http.HttpSession;

import java.io.IOException;

public class LoginActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("peixinchen") && password.equals("123456")) {
            User user = new User(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("profile-action");
        } else {
            resp.sendRedirect("login.html");
        }
    }
}
