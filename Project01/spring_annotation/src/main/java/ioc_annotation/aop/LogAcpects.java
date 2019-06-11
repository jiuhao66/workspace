package ioc_annotation.aop;


import jdk.nashorn.internal.objects.annotations.Setter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 *
 *       切面的方法的参数  要加 joinPoint  必须加方法参数第一位
 *
 * @author LX
 * @date 2019/3/25 - 19:28
 */

// 告诉spring  这个类是一个切面类
@Aspect
public class LogAcpects {

    //1: 抽取公共的 切入点 表达式
    // 1 本类引用
    //2.其他的切面引用
    @Pointcut("execution(public int ioc_annotation.aop.MathCalculator.*(..))")
    public void piontCut(){};

    //  @Before 在目标方法之前切入   在* 指的是任意方法  .. 是任意参数
    @Before("piontCut()")
    public void logStart(JoinPoint joinPoint){

        //获得 方法 的参数
        Object[] args = joinPoint.getArgs();

        System.out.println(" "+joinPoint.getSignature().getName()+"运行了...参数列表是 "+ Arrays.asList(args));
    }

    @After("piontCut()")
    public void logEnd(JoinPoint joinPoint){

        System.out.println(" "+joinPoint.getSignature().getName()+"结束了 ");
    }

    @AfterReturning(value = "piontCut()" ,returning = "result")
    public void logReturn(JoinPoint joinPoint , Object result){

        System.out.println(" "+joinPoint.getSignature().getName()+"正常返回...计算结果:"+ result);
    }

    @AfterThrowing(value = "piontCut()" , throwing = "exception")
    public void logException(JoinPoint joinPoint , Exception exception){

        System.out.println(" "+joinPoint.getSignature().getName()+"异常...异常信息是 "+exception);
    }
}
