package ioc_annotation.controller;

import ioc_annotation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author LX
 * @date 2019/3/17 - 10:19
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personServiceImpl;

    public void demo(){
        System.out.println(personServiceImpl);
    }

}
