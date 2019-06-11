package com.yc.controller;

import com.yc.bean.Person;
import com.yc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody
//@Controller RestController  代表 ResponseBody  Controller
 * @author LX
 * @date 2019/6/2 - 0:24
 */
//  ResponseBody的注解加载类上面  这个类的所有方法的数据直接写给浏览器
// 如果是对象转为 json 数据
//


@RestController
public class HelloController {

    @Autowired
    private Person person;

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello/{name}/{age}")
    public String hello(@PathVariable("name") String name, @PathVariable("age") int age){

        System.out.println(person.toString());

        helloService.hello();

        return "hello "+name+" "+ age;
    }
}
