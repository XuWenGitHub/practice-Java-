package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//注解的使用：小括号包裹多个属性，属性名=属性值，多个之间逗号间隔,属性名为value是可以缺省
//Servlet定义服务，注意服务路径必须是/开始，否则tomcat启动就会报错
@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
