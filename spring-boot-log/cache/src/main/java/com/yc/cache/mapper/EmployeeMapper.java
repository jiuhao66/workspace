package com.yc.cache.mapper;

import com.yc.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author LX
 * @date 2019/6/11 - 12:10
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName = #{lastName} ,email = #{email},gender = #{gender},d_id=#{dId} where id = #{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    void insertEmployee(Employee employee);
}
