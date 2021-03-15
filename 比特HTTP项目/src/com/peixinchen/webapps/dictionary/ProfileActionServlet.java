package com.peixinchen.webapps.dictionary;

import com.peixinchen.standard.ServletException;
import com.peixinchen.standard.http.HttpServlet;
import com.peixinchen.standard.http.HttpServletRequest;
import com.peixinchen.standard.http.HttpServletResponse;
import com.peixinchen.standard.http.HttpSession;

import java.io.IOException;

public class ProfileActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.html");
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().println(user.toString());
        }
    }
}
