package bean_annotation_test;

import ioc_annotation.config.MainConfig;
import ioc_annotation.config.MainConfig2;
import ioc_annotation.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author LX
 * @date 2019/3/17 - 10:07
 */
public class IOC_Test {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void testImport(){

        Person bean = (Person) ac.getBean("person");

        Person bean1 = (Person) ac.getBean("person1");

        System.out.println(bean);

        System.out.println(bean1);

       /* printNames();

        // 得到的是   里面创建的 对象
        Object workerFactoryBean = ac.getBean("workerFactoryBean");

        Object workerFactoryBean1 = ac.getBean("workerFactoryBean");
                                //加一个  &  得到本身的  workerfactoryBean 对象
//        Object workFactoryBean1 = ac.getBean("&workFactoryBean");

        System.out.println(workerFactoryBean == workerFactoryBean1);

        System.out.println("workFactoryBean 的类型 : "+ workerFactoryBean);*/
    }

    private void printNames(){

        String[] names = ac.getBeanDefinitionNames();

        for (String name : names){

            System.out.println(name);
        }
    }


    @Test
    public void test03(){

        String[] names = ac.getBeanNamesForType(Person.class);

        //得到运行 环境
        ConfigurableEnvironment environment = ac.getEnvironment();

        //得到系统名称
        String property = environment.getProperty("os.name");

        System.out.println("运行环境"+" "+property);

        for(String name : names){

            System.out.println(name);
        }

        Map<String, Person> personMap = ac.getBeansOfType(Person.class);

        System.out.println(personMap);
    }

    @Test
    public void test02(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);

        Object person = ac.getBean("person");

        Object person1 = ac.getBean("person");

        System.out.println( person == person1 );
    }

    @Test
    public void test01(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] names = ac.getBeanDefinitionNames();

        for (String t :names){

            System.out.println(t);
        }
    }
}
