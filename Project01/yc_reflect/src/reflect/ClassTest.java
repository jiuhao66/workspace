package reflect;

/**
 * @author LX
 * @date 2019/3/15 - 20:12
 */
public class ClassTest {

    public static void main(String[] args) {

        Class stringClass = String.class;

        // 返回接口数组
        Class[] interfaces = stringClass.getInterfaces();

        for (Class cls : interfaces) {

            System.out.println(cls);
        }

        // 获得类名:  包名 + 类名
        System.out.println(stringClass.getName());

        //剪短类名:   类名
        System.out.println(stringClass.getSimpleName());

        //返回父类的  类对象
        System.out.println(stringClass.getSuperclass());

        //返回类的所有的注解对象
        stringClass.getAnnotations();

        /**
         * 获取属性
         */

        //返回类共有的指定属性名称属性, 不带Declared  公有

    }
}


class B{

    public B() {
    }

    public int age;

    protected String name;

    private String email;


    @Override
    public String toString() {
        return "B{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


class A extends B{
    public int age ;

    protected String name;

    @Override
    public String toString() {
        return "A{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
