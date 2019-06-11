package menutest.pojo;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/3/2 - 14:34
 */
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;

    private Emp emp;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc, Emp emp) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.emp = emp;

    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    @Override
    public String toString() {

        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
