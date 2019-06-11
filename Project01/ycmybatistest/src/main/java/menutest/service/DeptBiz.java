package menutest.service;

import menutest.mapper.DeptMapper;
import menutest.mapper.EmpMapper;
import menutest.pojo.Dept;
import menutest.pojo.Emp;

/**
 * @author LX
 * @date 2019/3/9 - 20:26
 */
public class DeptBiz {

    private DeptMapper deptMapper;

    private EmpMapper empMapper;

    public void addDept(Dept dept, Emp emp){

        deptMapper.insDept(dept);

        System.out.println(dept.getDeptno());
    }

    public DeptMapper getDeptMapper() {
        return deptMapper;
    }

    public void setDeptMapper(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public EmpMapper getEmpMapper() {
        return empMapper;
    }

    public void setEmpMapper(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

}
