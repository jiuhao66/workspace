package com.yc.springbootlog.config;

import com.yc.springbootlog.interceptor.UserHandlerInterceptor;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author LX
 * @date 2019/6/4 - 23:02
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加 拦截器 进行登录检查
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new UserHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/*.u");
    }

    /**
     * 所有的 WebMvcConfigurerAdapter组件都会一起 起作用
     * 增加 视图解析器
     * 浏览器发送一个   一个请求novel   请求来到 index
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/novel").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }
}
