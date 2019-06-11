package ioc_annotation.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author LX
 * @date 2019/3/17 - 11:54
 */
// 判断是否  是 windows
public class WindowsCondition implements Condition {

    /**
     * conditionContext :判断条件 能使用的 上下文(环境 )
     * annotatedTypeMetadata: 注释信息
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 能够获得 ioc beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        //获得 当前环境
        Environment environment = conditionContext.getEnvironment();

        //获得 bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");

        if(property.contains("Windows")){

            return true ;
        }
        return false;
    }
}
