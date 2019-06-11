package menutest.pojo;

/**
 * @author LX
 * @date 2019/1/30 - 17:52
 */
public class Student {
    private int id;
    private String name ;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
