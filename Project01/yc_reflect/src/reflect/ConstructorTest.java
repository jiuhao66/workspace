package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author LX
 * @date 2019/3/15 - 21:27
 */
public class ConstructorTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /**
         * 构造方法 用于 创建对象
         *
         * 使用反射 创建对方一 :  类对象 newInstance 方式
         *
         * 调用 无参数的构造方式
         * 如果目标类没有无参数 构造方法,则报错
         */

        Constructor c = B.class.getConstructor();

        B b = (B)c.newInstance();

        b.age = 10;

        System.out.println(b);
    }
}
