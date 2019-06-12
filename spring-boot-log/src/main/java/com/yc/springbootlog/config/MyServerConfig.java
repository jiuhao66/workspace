package com.yc.springbootlog.config;

import com.yc.springbootlog.filter.MyFilter;
import com.yc.springbootlog.listener.MyListener;
import com.yc.springbootlog.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author LX
 * @date 2019/6/6 - 10:50
 */
@Configuration
public class MyServerConfig {

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){

        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean(new MyListener());

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new MyFilter());

        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet","/index"));

        return filterRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");

        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){

        //  定制 嵌入式的servlet 容器相关的规则
        return (container)->{container.setPort(80);};
    }
}
