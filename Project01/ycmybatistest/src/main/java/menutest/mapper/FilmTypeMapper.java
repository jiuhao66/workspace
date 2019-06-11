package menutest.mapper;

import menutest.pojo.FilmType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 15:08
 */
public interface FilmTypeMapper {

    List<FilmType> selAll();

    FilmType selByName(@Param("typeName") String typeName);

    FilmType selByTypeID(@Param("typeID") int typeID);
}
