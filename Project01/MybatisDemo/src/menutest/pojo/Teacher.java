package menutest.pojo;

import java.util.List;

/**
 * @author LX
 * @date 2019/1/2 - 20:10
 */
public class Teacher {

    private int tid;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    private String  name;

    List<Student>studentList ;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
