package ioc_annotation.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 的后置处理器
 * @author LX
 * @date 2019/3/18 - 20:42
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        System.out.println("postProcessBeforeInitialization6   "+ s+ " "+ o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        System.out.println("postProcessAfterInitialization5  "+ s+ " "+ o);

        return o;
    }
}
