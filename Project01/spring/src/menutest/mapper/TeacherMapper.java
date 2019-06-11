package menutest.mapper;

import menutest.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LX
 * @date 2019/1/30 - 19:05
 */
public interface TeacherMapper {

    @Select("select * from teacher")
    List<Teacher> selAll();
}
