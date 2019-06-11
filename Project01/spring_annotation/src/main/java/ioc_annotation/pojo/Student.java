package ioc_annotation.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author LX
 * @date 2019/3/17 - 15:57
 */
public class Student {

    @PreDestroy
    public void destroy() throws Exception {

        System.out.println("student destroy ...");

    }

    @PostConstruct
    public void init() {

        System.out.println(" student  init ....");
    }
}
