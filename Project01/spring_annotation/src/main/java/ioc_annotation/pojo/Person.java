package ioc_annotation.pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author LX
 * @date 2019/3/17 - 9:23
 */
public class Person {

    /**
     *  使用 Value赋值
     *  1.基本数值
     *  2.可以写SpEL #{}
     */
    @Value("#{50*20}")
    private int age ;

    @Value("zhangsan")
    private String name;

    @Value("${person.nickName}")
    private String nickName;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
