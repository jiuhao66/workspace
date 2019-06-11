package menutest.pojo;

/**
 * @author LX
 * @date 2018/12/25 - 21:00
 */
public class Student {
    private int sid;
    private String name;
    private Teacher teacher;

    public int getSid() {
        return sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
