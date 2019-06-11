package menutest.mapper;

import menutest.pojo.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/10 - 19:56
 */
public interface FavoriteMapper {

    /**
     * 新增收藏地址
     * @param favorite
     * @return
     */
    int insNew(Favorite favorite);

    /**
     * 查询全部
     * @return
     */
    List<Favorite>selAll();

    /**
     * 查"全部"
     * @return
     */
   /* @Select("select * from favorite where tags is null ")
    List<Favorite>selByNoTags();*/

    /**
     * 根据 标签来查
     * @return
     */
    List<Favorite>selByTag(@Param("tags") String tags);
}
