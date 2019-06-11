package IocDItest1;

import menutest.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc  和  di
 * @author LX
 * @date 2019/1/30 - 17:37
 */
public class Test {

    public static void main(String[] args) {


        ApplicationContext ac = new ClassPathXmlApplicationContext("IocDIApplicationContext.xml");

        Teacher teacher = ac.getBean("teacher", Teacher.class);

        System.out.println(teacher.toString());


    }
}
