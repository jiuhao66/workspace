package menutest.mapper;

import menutest.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 11:09
 */
public interface EmpMapper {

    List<Emp> selAll();

    Emp selOne(@Param("id") int id );

    List<Emp>selInEmpno(List<Integer> empnoList);

    void insEmp(Emp emp);
}
