package com.study.javademospringwechat.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class BusinessExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> ExceptionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> result=new HashMap<>();
        result.put("success",false);
        result.put("msg",e.getMessage());
        return result;
    }

}
