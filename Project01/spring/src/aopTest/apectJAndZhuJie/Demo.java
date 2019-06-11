package aopTest.apectJAndZhuJie;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/2/2 - 10:14
 */
@Component
public class Demo {

    @Pointcut( value = "execution(* aopTest.apectJAndZhuJie.Demo.demo1()) ")
    public void demo1(){

    }

    public void demo2() throws Exception{

        int i = 5/0;
        System.out.println("demo2");
    }

    public void demo3(int number1 , String name1){
        System.out.println("demo3");
    }
}
