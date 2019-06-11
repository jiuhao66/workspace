package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LX
 * @date 2019/6/1 - 17:17
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(){

        return "hello world";
    }
}
