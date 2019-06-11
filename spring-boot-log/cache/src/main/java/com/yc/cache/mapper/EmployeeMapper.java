package com.yc.cache.mapper;

import com.yc.cache.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author LX
 * @date 2019/6/11 - 12:10
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);
}
