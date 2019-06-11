package aopTest.schema_base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LX
 * @date 2019/2/1 - 11:47
 */
public class Test {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("AopSchemaBaseApplicationContext.xml");

        Demo demo = ac.getBean("demo",Demo.class);

        demo.demo1("李鑫",6);

        /*try {
            demo.demo1();
        } catch (Exception e) {
//            e.printStackTrace();
        }*/

     //   demo.demo3();

    }
}
