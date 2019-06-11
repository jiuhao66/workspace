package com.yc.datademo.mapper;

import com.yc.datademo.bean.Novel;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LX
 * @date 2019/6/9 - 11:11
 */
//@Mapper
public interface NovelMapper {

    /**
     *       在插入的时候  要想 获得 自增的id   需要加一个注解
     *       @Options(useGeneratedKeys = true,keyProperty = "nid")
     * @param id
     * @return
     */

    @Select("select * from novel where nid = #{nid}")
    Novel getNovelById(long id);

    Novel getNovelByNovelName(@Param("novelName") String novelName);

}
