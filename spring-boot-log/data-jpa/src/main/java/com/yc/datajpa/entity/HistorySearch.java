package com.yc.datajpa.entity;

import javax.persistence.*;

/**
 * 使用 JPA 注解 配置映射关系
 * entity  告诉JPA这是一个 实体类  (和数据表映射的类)
 * Table 来指定和哪个 数据表对应,如果省略  默认就是 首字母小写
 * @author LX
 * @date 2019/6/9 - 15:32
 */
@Entity
@Table(name = "historysearch")
public class HistorySearch {

    // 设置自增主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private long sid ;

    /**
     * column 标注的是 这个是和数据表对应的  一个列
     */
    @Column
    private long uid ;
    /**
     *  不写 name  省略的话 默认就是 属性名
     */
    @Column(name = "historySearchName")
    private String historySearchName;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getHistorySearchName() {
        return historySearchName;
    }

    public void setHistorySearchName(String historySearchName) {
        this.historySearchName = historySearchName;
    }
}
