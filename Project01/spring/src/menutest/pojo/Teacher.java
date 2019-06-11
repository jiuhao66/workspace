package menutest.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author LX
 * @date 2019/1/29 - 17:15
 */
public class Teacher {
    private int id ;
    private String name;
    private List<String>list;
    private Map<String,String> map;
    private String []names;
    private Student student;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", map=" + map +
                ", names=" + Arrays.toString(names) +
                ", student=" + student +
                '}';
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public int getId() {
        return id;
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
