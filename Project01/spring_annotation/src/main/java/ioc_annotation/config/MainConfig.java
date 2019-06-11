package ioc_annotation.config;

import ioc_annotation.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 配置类  等于 配置文件
 * @author LX
 * @date 2019/3/17 - 9:31
 */
//@Conditional({LinuxCondition.class})
@Configuration    // 告诉 spring 这个是一个配置文件
//@ComponentScan(value = "ioc_annotation",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION ,classes = {Controller.class,Configuration.class})
//})
//,
//FilterType.CUSTOM,classes = {MyTypeFilter.class} 自定义过滤规则
//FilterType.ASSIGNABLE_TYPE 根据类型  来扫描
//FilterType.ANNOTATION  按照注解扫描
//@ComponentScan  value :指定要扫描的包
//excludeFilters = Filter[]  指定 扫描的时候 指定按照 什么规则排除 那些组件
//includeFilters = Filter[]  指定 扫描的时候 只需要包含那些组件
//使用includeFilters  需要添加 ,useDefaultFilters = false    默认是 扫描全部  false改为不扫描全部
//jdk8之后 可以重复 只用ComponentScan   也可以用ComponentScans  里面包含 多个ComponentScan
@ImportResource
public class MainConfig {

    // 给容器 注册一个bean  ;  类型为返回值的类型  id 为方法名
    @Bean
    public Person person(){

        return new Person(20,"li6");
    }

    @Bean
    public Person person1(){

        return new Person();
    }
}
