package ioc_annotation.config;

import ioc_annotation.pojo.Person;
import ioc_annotation.pojo.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 给属性赋值
 * @author LX
 * @date 2019/3/18 - 21:35
 */
//  使用 @PropertySource  读取外部文件中的 k/v
@PropertySource(value = "classpath:/person.properties",encoding = "UTF-8")

@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Teacher teacher(){

        return new Teacher();
    }

    @Bean
    public Person person(){

        return new Person();
    }


}
