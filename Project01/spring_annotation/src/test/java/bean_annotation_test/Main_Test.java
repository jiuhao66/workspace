package bean_annotation_test;

import ioc_annotation.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LX
 * @date 2019/3/17 - 9:26
 */
public class Main_Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean_annotation_applicationContext.xml");

        Person bean = ac.getBean(Person.class);

        System.out.println(bean);


       /* ApplicationContext ApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        Person bean = ApplicationContext.getBean(Person.class);

        Person bean1 = (Person) ApplicationContext.getBean("person12");

        System.out.println(bean==bean1);*/
    }
}
