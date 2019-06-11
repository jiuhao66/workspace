package com.yc.spring.config;

import com.yc.service.HelloService;
import com.yc.service.impl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LX
 * @date 2019/6/2 - 15:44
 */
@Configuration
public class BeanConfig {

    @Bean
    public HelloService getHelloService(){
        return new HelloServiceImpl();
    }
}
