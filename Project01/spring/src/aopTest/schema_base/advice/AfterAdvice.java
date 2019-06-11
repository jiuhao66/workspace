package aopTest.schema_base.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author LX
 * @date 2019/2/1 - 11:47
 */
public class AfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        /*o是返回值     */

        System.out.println("这是 后置通知   返回值:"+o.toString()+"  参数 :"+objects.length);

    }
}
