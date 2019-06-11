package com.yc.springbootlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @author LX
 * @date 2019/6/4 - 21:45
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String  hello() throws Exception {

       throw new Exception();
    }

    @RequestMapping("/index")
    public String success(Map<String,Object>map){
        map.put("hello", "<h1>9999</h1>");
        map.put("lists", Arrays.asList("lixin","yanliang","meinv"));
        return "index";
    }

}
