package bean_annotation_test;

import ioc_annotation.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LX
 * @date 2019/3/17 - 20:11
 */
public class IOC_LifeCycle_Test {


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test1(){

        System.out.println("容器创建完成   .......");

        //关闭容器
        context.close();

    }
}
