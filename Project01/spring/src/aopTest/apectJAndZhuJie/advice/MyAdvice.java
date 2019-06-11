package aopTest.apectJAndZhuJie.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/2/2 - 10:15
 */
@Component
@Aspect
public class MyAdvice {

    @Before("aopTest.apectJAndZhuJie.Demo.demo1()")
    public void beforeAdvice(){

        System.out.println("这是前置通知");
    }

    @After("aopTest.apectJAndZhuJie.Demo.demo1()")
    public void afterAdvice(){

        System.out.println("这是后置通知");
    }

    @AfterThrowing("aopTest.apectJAndZhuJie.Demo.demo1()")
    public void throwAdvice(){

        System.out.println("这是异常通知");
    }

    @Around("aopTest.apectJAndZhuJie.Demo.demo1()")
    public Object arroundAdvice(ProceedingJoinPoint p) throws Throwable {

        System.out.println("执行环绕");

        System.out.println("环绕_前置");

        Object proceed = p.proceed();

        System.out.println("环绕_后置");

        return proceed;
    }


    public void beforeAdvice3(int number,String name){

        System.out.println(number+"  "+name);

        System.out.println("这是前置通知");

    }
}
