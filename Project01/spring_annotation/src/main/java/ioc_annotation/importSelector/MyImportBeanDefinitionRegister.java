package ioc_annotation.importSelector;

import ioc_annotation.pojo.School;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author LX
 * @date 2019/3/17 - 19:25
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * 原来就是通过的到  beanDefinitionRegister 来 注入 bean
     *
     *
     * @param annotationMetadata  当前类的注解信息
     * @param registry   beanDefinition注册类
     *                                 把所有需要添加到容器中bean
     *                 beanDefinitionRegister.registerBeanDefinitions
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                       BeanDefinitionRegistry registry) {

        //通过 import  和 importSelector 注册的bean 是全路径
        boolean b = registry.containsBeanDefinition("ioc_annotation.pojo.Student");

        boolean b1 = registry.containsBeanDefinition("ioc_annotation.pojo.Teacher");

        if(b&&b1){


            //指定一个 bean 的定义信息  可以使用setScope(); lazy  定义 bean 的 模式
            RootBeanDefinition definition = new RootBeanDefinition(School.class);

            //注册一个 bean  指定一个 bean名
            registry.registerBeanDefinition("school",definition);
        }


    }
}
