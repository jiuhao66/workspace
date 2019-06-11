package bean_annotation_test;

import ioc_annotation.aop.MathCalculator;
import ioc_annotation.config.MainConfigAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LX
 * @date 2019/3/25 - 19:56
 */
public class AOP_Test1 {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAOP.class);
    @Test
    public void test(){

        MathCalculator mathCalculator = context.getBean(MathCalculator.class);

        mathCalculator.div(1, 1);
    }
}
