package ioc_annotation.pojo;

import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/3/17 - 20:06
 */
@Component
public class CarLife {

    public CarLife() {

    }

    public void init(){

        System.out.println("car .....init ..");
    }

    public void destroy(){

        System.out.println("car .....destroy ..");
    }
}
