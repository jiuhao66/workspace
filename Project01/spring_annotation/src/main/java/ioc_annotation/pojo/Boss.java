package ioc_annotation.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/3/19 - 20:04
 */

// 默认加在 ioc容器中的组件 ,  容器启动会调用 无参构造器 创建对象  ,再进行初始化赋值等操作
@Component
public class Boss {

    private CarLife carLife;

    public CarLife getCarLife() {
        return carLife;
    }

    public Boss() {
    }

    public Boss(@Autowired CarLife carLife) {
        this.carLife = carLife;
    }

    @Autowired
    public void setCarLife(CarLife carLife) {
        this.carLife = carLife;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "carLife=" + carLife +
                '}';
    }
}
