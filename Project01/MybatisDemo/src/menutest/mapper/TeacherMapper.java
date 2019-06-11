package menutest.mapper;

import menutest.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LX
 * @date 2019/1/2 - 20:12
 */
public interface TeacherMapper {

    @Select("select * from  teacher where tid = #{tid}")
    Teacher selByTid(@Param("tid") int tid);

    Teacher selBytidTosid(@Param("tid") int tid);


}
