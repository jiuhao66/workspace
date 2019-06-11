package test;


import menutest.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.util.TeacherFactory;
import test.util.TeacherStaticFactory;

/**
 * @author LX
 * @date 2019/1/29 - 17:13
 */
public class Test {

    public static void main(String[] args)  {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 普通的  方法 构建
        Teacher teacher = ac.getBean("teacher", Teacher.class);

        System.out.println(teacher.toString());
        System.out.println("--------------------------------");


        // 实例工厂构建
        TeacherFactory teacherFactory = ac.getBean("teacherFactory", TeacherFactory.class);

        Teacher teacher1 = teacherFactory.newInstance();

        System.out.println(teacher1.toString());


        Teacher teacher11 = ac.getBean("teacher1", Teacher.class);

        System.out.println(teacher11);

        System.out.println("--------------------------------");


        //静态工厂构建类

        Teacher teacher2 = TeacherStaticFactory.newInstace();


        //遍历 配置文件 里面所有的 name

        String[] names = ac.getBeanDefinitionNames();

        for (int i = 0; i <names.length ; i++) {

            System.out.println(names[i]);

        }


    }
}
