package bean_annotation_test;

import ioc_annotation.config.MainConfigAutowired;
import ioc_annotation.pojo.Boss;
import ioc_annotation.pojo.CarLife;
import ioc_annotation.pojo.Worker;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LX
 * @date 2019/3/19 - 19:25
 */
public class IOC_autoWired_Test {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAutowired.class);
    @Test
    public void test(){

       /* PersonController bean = context.getBean(PersonController.class);

        bean.demo();*/

        Boss bean = context.getBean(Boss.class);

        CarLife bean1 = context.getBean(CarLife.class);

        Worker bean2 = context.getBean(Worker.class);

        System.out.println(bean2);

        System.out.println(bean1);

        System.out.println(bean);

        System.out.println("注入的容器: "+context);


        context.close();
    }
}
