package com.yc.datademo.bean;

/**
 * @author LX
 * @date 2019/6/9 - 11:10
 */
public class Novel {

    private long nid ;
    private String novelName;

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "nid=" + nid +
                ", novelName='" + novelName + '\'' +
                '}';
    }
}
