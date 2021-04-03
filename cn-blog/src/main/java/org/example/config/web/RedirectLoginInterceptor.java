package org.example.config.web;

import org.example.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedirectLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session，如果获取不到，返回null
        HttpSession session = request.getSession(false);
        if(session!=null){
            User user = (User) session.getAttribute("user");
            if(user!=null){
                return true;
            }
        }
        //前端敏感资源，没有登录时，直接重定向到登录页面即可
        response.sendRedirect("/views/login.html");
        return false;
    }
}
