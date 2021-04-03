package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.AppException;
import org.example.model.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Object handle(AppException e){
        log.debug("自定义异常",e);
        Response resp = new Response();
        resp.setCode(e.getCode());
        resp.setMessage(e.getMessage());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e){
        log.error("非自定义异常",e);
        Response resp = new Response();
        resp.setCode("ERROR000");
        resp.setMessage("未知错误，请联系管理员");
        return resp;
    }
}
