package com.yc.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 *  ConfigurationProperties 告诉spring boot
 将本类中的所有属性和配置文件中相关的配置进行绑定
    默认是从 全局文件获取的

    @PropertySource
    和ConfigurationProperties 配合使用
    PropertySource指示 当前的 ConfigurationProperties配置文件
    全局配置符合条件就走 全局的  不然就走指定的配置文件
 * @author LX
 * @date 2019/6/2 - 11:15
 */

@Component
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name ;

    private int age ;

    private List<Object>list;

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    private Map<String,Object> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
