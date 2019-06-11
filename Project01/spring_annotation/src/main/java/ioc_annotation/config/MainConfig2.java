package ioc_annotation.config;

import ioc_annotation.condition.LinuxCondition;
import ioc_annotation.condition.WindowsCondition;
import ioc_annotation.importSelector.MyImportBeanDefinitionRegister;
import ioc_annotation.importSelector.MyImportSelector;
import ioc_annotation.pojo.Person;
import ioc_annotation.pojo.Student;
import ioc_annotation.pojo.WorkerFactoryBean;
import org.springframework.context.annotation.*;

/**
 * @author LX
 * @date 2019/3/17 - 11:06
 */
// 类中组件 统一设置  满足条件 , 这个类配置的所有bean注册才能生效
//@Conditional({LinuxCondition.class})

@Conditional({LinuxCondition.class})
@Configuration
@ComponentScan(value = "ioc_annotation",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = {Configuration.class})
})
// 导入组件  id默认是组件的全名
@Import({Student.class,  MyImportSelector.class , MyImportBeanDefinitionRegister.class})

public class MainConfig2 {

    /**
     * scope 指明  模式  默认 为单例模式
     * request  同一次请求 创建一个实例
     * session 同一个session创建一个实例
     *
     * 默认是单实例的时候  ioc容器启动时 会调用方法创建对象放到ioc容器中
     * 以后每次获取  直接从容器拿
     *
     * 懒加载  针对 单实例  @Lazy
     *       容器创建的时候  不实例化   第一次使用 bean 创建对象的时候 初始化
     * @return
     */
//    @Scope("prototype")

    @Lazy
    @Bean
    public Person person(){

        System.out.println("创建  person ");

        return new Person();
    }

    /**
     * @conditional : 按照一定的条件进行判断 ,满足条件 给容器中注册bean
     */
    @Conditional({WindowsCondition.class})
    @Bean(value = "bill")
    public Person person1(){

        return new Person(30,"kun");
    }

    @Conditional({LinuxCondition.class})
    @Bean(value = "linux"  )
    public Person person2(){

        return new Person(60,"linux");
    }

    /**
     * 给容器中 注册 组件
     * 1: 包扫描 + 组件 标注 注解  (@Controller @Service @Component @Repository @Resources)
     * 2: @Bean[导入第三方包里面的组件]
     * 3: @Import[快速给容器中导入一个组件]
     *   3.1  @Import(要导入到容器中组件) , 容器中就会自动注册这个组件,id默认是 class 的全路径
     *   3.2  ImportSelector : 返回需要导入的组件的全类名数组
     *   3.3  ImportBeanDefinitionRegister :  手动注册 bean
     * 4: 使用spring提供的 factoryBean
     */

    @Bean
    public WorkerFactoryBean workerFactoryBean(){

        return  new WorkerFactoryBean();
    }

}
