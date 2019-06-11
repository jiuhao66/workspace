package menutest.pojo;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/3/10 - 19:51
 */
public class Tag implements Serializable{

    private static final long serialVersionUID=1;

    @Override
    public String toString() {
        return "Tag{" +
                "tid=" + tid +
                ", tName='" + tName + '\'' +
                ", tCount=" + tCount +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer gettCount() {
        return tCount;
    }

    public void settCount(Integer tCount) {
        this.tCount = tCount;
    }

    private Integer tid;

    private String tName;

    private Integer tCount;
}
