package bean_annotation_test;

import ioc_annotation.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LX
 * @date 2019/3/18 - 21:39
 */
public class IOCPropertyValues_Test {

    AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test(){

        // 通过 得到环境  来得到  外部文件的值
        /*ConfigurableEnvironment environment = context.getEnvironment();

        String property = environment.getProperty("person.nickName");*/

        context.close();
    }

    private void printNames(){

        String[] names = context.getBeanDefinitionNames();

        for (String name : names){

            System.out.println(name);
        }
    }
}