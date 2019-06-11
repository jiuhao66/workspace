package ioc_annotation.config;

import ioc_annotation.pojo.CarLife;
import ioc_annotation.pojo.MyBeanPostProcessor;
import ioc_annotation.pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * bean 的生命 周期   创建 到 初始化 到 销毁
 * 容器管理 bean的生命周期
 * 我们可以自定义 初始化 和销毁 方法
 *           容器在bean 进行到当前生命周期的时候来调用 我们自定义的初始化 和销毁方法
 *
 *      1: 指定 初始化 和销毁 方法 :
 *      指定 init-method  和 destroy-method
 *         用 bean中的   initMethod  和destroyMethod
 *
 *      2: 初始化 实现 initializingBean 初始化
 *                    DisposableBean    销毁
 *      3: 可以使用 JSR250 ;
 *         PostConstruct : 在bean 创建完成 并且属性赋值完成  来指定初始化
 *         preDestroy    在容器销毁bean之前通知  清理工作
 *
 *
 *      4: BeanPostProcessor  : bean的后置处理器    会作用于 所有的单实例 的类
 *     初始化之前调用 postProcessBeforeInitialization
 *     初始化之后     postProcessAfterInitialization
 *            在bean初始化前后进行一些处理工作
 *
 *      单实例时候 : 在容器启动的时候 创建对象       容器关闭的时候 销毁
 *      多实例时候 : 在每次 获取的时候在创建对象     容器不会帮你销毁
 *
 *      Spring底层对BeanPostProcessor 的使用
 *      bean赋值 注入其他组件 , @Autowired 生命周期
 *
 *
 * @author LX
 * @date 2019/3/17 - 20:02
 */
@Configuration

@ComponentScan(value = "ioc_annotation",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Component.class,Configuration.class})
}  )

public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init" ,destroyMethod = "destroy")
    public CarLife carLife(){

        return new CarLife();
    }

   /* @Bean
    public Peope peope(){

        return new Peope();
    }*/

   @Bean
   public Student student(){

       return new Student();
   }

   @Bean
   public MyBeanPostProcessor myBeanPostProcessor(){

       return new MyBeanPostProcessor();
   }

}
