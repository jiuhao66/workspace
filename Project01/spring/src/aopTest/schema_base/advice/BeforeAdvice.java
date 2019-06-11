package aopTest.schema_base.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author LX
 * @date 2019/2/1 - 11:50
 */
public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        /*  method 是 方法名     object是参数集合   o 是 方法所在的类*/


        System.out.println("这是 前置通知   参数 :" + objects[0]+ " "+ objects[1]);
    }
}
