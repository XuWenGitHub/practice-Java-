package org.example.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.example.model.Response;
import org.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/1")
    public Object u1(){
        Response resp = new Response();
        resp.setCode("1");
        return resp;
    }

    @GetMapping("/2")
    public Object u2(){
        User user = new User();
        user.setUsername("徐文");
        return user;
    }

    @GetMapping("/3")
    public String u3(){
        return "u3";
    }

    @GetMapping("/4")
    public Object U4(){
        return null;
    }

    /**
     * 这样返回字符串作为响应头，会在包装为统一数据格式时报错
     * 避免这种返回即可
     * 正式项目时：提供解决方案
     * @return
     */
    @GetMapping("/5")
    public String u5(){
        return null;
    }
}
