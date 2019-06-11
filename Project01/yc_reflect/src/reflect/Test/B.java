package reflect.Test;

/**
 * @author LX
 * @date 2019/3/16 - 21:27
 */
public class B {

    public int age ;

    private String name ;

    @Override
    public String toString() {
        return "B{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
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
