package com.yc.springbootlog.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author LX
 * @date 2019/6/6 - 11:42
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("容器的创建...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("容器的销毁...");
    }

}
