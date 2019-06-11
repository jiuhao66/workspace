package aopTest.apectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LX
 * @date 2019/2/2 - 10:14
 */
public class Test {
    public static void main(String[] args) {


        ApplicationContext ac = new ClassPathXmlApplicationContext("AopApectjApplicationContext.xml");

        Demo demo = ac.getBean("demo", Demo.class);

        demo.demo1();

        System.out.println(6);

        try {

            demo.demo2();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        demo.demo3(2,"lixin");
    }
}
