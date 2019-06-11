package ioc_annotation.config;

import ioc_annotation.pojo.CarLife;
import ioc_annotation.pojo.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LX
 * @date 2019/3/19 - 0:02
 */

/**
 * 自动装配 :
 *      spring利用依赖注入(DI) 完成自动依赖注入
 *
 *       inject  和 autowired 用法一样   但是 没有required    属性
 *   1) @Autowired(required = false ) 自动注入   默认为true  必须要装上
 *      为 false  就非必须   有就 装  没有就不装
 *
 *        1:默认优先按照类型去容器中找对应的组件:
 *        2:如果找到多个相同类型的组件 ,再将属性名称作为组件的id 去容器查找
 *
 *        @ primary 指定  首选 装配这个    qualifier的等级比 它到  同用
 *
 *        @ Qualifier("")  明确指定要装配的组件
 *
 *    2) @resource  和 @Inject 也能自动注入 [java规范 ]
 *        @resource
 *        默认是按照 属性的名称 来装配
 *
 * 例子 请看  boss
 *    3) @Autowired 可以作用于  构造方法  属性  方法上面  参数位置
 *
 *          @ Autowired 标注在方法上面  spring容器创建当前对象  就会调用方法,完成赋值
 *
 *          方法使用的参数 , 自定义类型的值  要从 容器中获取
 *
 *          如果组件只有一个  有参构造器 ,这个有参构造器的 @ Autowired 可以省略不写 可以自动获取
 *
 * 自定义组件想要 使用 spring容器底层的一些组件 (applicationContext .BeanFactory ...)
 *
 *  自定义组件实现 xxxAware 在创建对象时 ,会调用接口规定的方法注入相关的组件 Aware
 *  吧spring底层一些组件注入到自定义的bean中
 *  xxxAware 功能使用xxxAwareProcessor :
 *  例如:   ApplicationContextAware ==>  ApplicationContextAwareProcessor
 *
 */
@Configuration
@ComponentScan(value = {"ioc_annotation.service","ioc_annotation.controller","ioc_annotation.pojo"})
public class MainConfigAutowired {

    /**
     * @ Bean 标注的方法 创建对象的时候 ,方法参数的值 从容器中 获取
     *
     * @param carLife
     * @return
     */
    @Bean
    public Worker worker(CarLife carLife){

        Worker worker = new Worker();

        worker.setCarLife(carLife);

        return worker;
    }

}
