package lambda;

import java.util.Objects;

/**
 * @author LX
 * @date 2019/4/12 - 19:29
 */
public class User {
    private double number;
    private String name;

    public User(double number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.number, number) == 0 &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, name);
    }
}
