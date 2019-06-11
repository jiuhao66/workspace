package menutest.pojo;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/3/10 - 19:55
 */
public class Favorite implements Serializable {

    private static final long serialVersionUID=1;

    private Integer fid;

    private String fLabel;

    private String fUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "fid=" + fid +
                ", fLabel='" + fLabel + '\'' +
                ", fUrl='" + fUrl + '\'' +
                ", fTags='" + fTags + '\'' +
                ", fDesc='" + fDesc + '\'' +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getfLabel() {
        return fLabel;
    }

    public void setfLabel(String fLabel) {
        this.fLabel = fLabel;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public String getfTags() {
        return fTags;
    }

    public void setfTags(String fTags) {
        this.fTags = fTags;
    }

    public String getfDesc() {
        return fDesc;
    }

    public void setfDesc(String fDesc) {
        this.fDesc = fDesc;
    }

    private String fTags;

    private String fDesc;

}
