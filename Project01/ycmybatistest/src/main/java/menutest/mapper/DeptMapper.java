package menutest.mapper;

import menutest.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 9:00
 */
public interface DeptMapper {

    public  List<Dept> selAll();

    public Dept selOne(@Param("id") int id);

    int insBatch(List<Dept> deptList);

    int insDept(Dept dept);
}
