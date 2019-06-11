package ioc_annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author LX
 * @date 2019/3/17 - 11:54
 */
// 判断是否是  linux 系统
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        Environment environment = conditionContext.getEnvironment();

        String property = environment.getProperty("os.name");

        if(property.contains("Linux")){

            return true;
        }
        return false;
    }
}
