package aopTest.apectj.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author LX
 * @date 2019/2/2 - 10:15
 */
public class MyAdvice {

    public void beforeAdvice(){

        System.out.println("这是前置通知");
    }

    public void afterAdvice(){

        System.out.println("这是后置通知");
    }

    public void throwAdvice(){

        System.out.println("这是异常通知");
    }

    public Object arroundAdvice(ProceedingJoinPoint p) throws Throwable {

        System.out.println("执行环绕 ");
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
