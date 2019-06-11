package menutest.mapper;

import menutest.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LX
 * @date 2019/1/2 - 20:12
 */
public interface StudentMapper {

    @Select("select * from student ")
    List<Student> selAll();

    Student selByid(@Param("id") int id );

    List<Student> selBytid(@Param("tid") int tid );
}
