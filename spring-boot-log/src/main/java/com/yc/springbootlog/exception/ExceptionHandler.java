package com.yc.springbootlog.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理异常     分发出页面
 * @author LX
 * @date 2019/6/5 - 18:14
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();

        request.setAttribute("javax.servlet.error.status_code", "500");
        map.put("code", "用户不存在");
        map.put("message", e.getMessage());
        request.setAttribute("map", map);

        return "forward:/error";
    }
}
