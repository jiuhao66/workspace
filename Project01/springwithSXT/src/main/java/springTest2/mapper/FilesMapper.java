package springTest2.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import springTest2.pojo.Files;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/14 - 18:10
 */
public interface FilesMapper {

    @Select("select * from files")
    List<Files> selAll();

    @Update("update files set count =count +1 where name=#{name} and id=#{id}")
    int updCount(Files files);
}
