package springTest2.pojo;

/**
 * @author LX
 * @date 2019/3/14 - 17:28
 */
public class Files {

    private Integer id;
    private String name;
    private Integer count;

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
