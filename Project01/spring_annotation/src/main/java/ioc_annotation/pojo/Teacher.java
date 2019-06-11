package ioc_annotation.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 *EmbeddedValueResolverAware 作用是 解析 spring中的 一些 ${}  #{}
 */
@Component
public class Teacher implements ApplicationContextAware ,BeanNameAware ,EmbeddedValueResolverAware{

    @Override
    public void setBeanName(String s) {

        System.out.println("当前bean的名字: "+s);
    }

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("传入的ioc: "+applicationContext);

        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

        String stringValue = stringValueResolver.resolveStringValue("你好${os.name}  我是#{2*30}");

        System.out.println(stringValue);
    }
}
