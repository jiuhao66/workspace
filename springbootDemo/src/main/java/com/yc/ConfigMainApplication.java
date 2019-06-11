package com.yc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 用 ImportResources 导入外部的文件  一些spring的配置xml
 *
 * @author LX
 * @date 2019/6/1 - 23:21
 */
//@ImportResource(locations = {"classpath:spring_jdbc.xml"})
@SpringBootApplication
public class ConfigMainApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigMainApplication.class,args);

    }
}
