package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springTest2.pojo.Users;

/**
 * @author LX
 * @date 2019/3/13 - 23:12
 */
@Controller
public class DemoController {

    @RequestMapping("exception")
    public String demo1(String name){

        System.out.println(name);

        Users users = null;

        users.getId();

        return  "main.jsp";
    }


}
