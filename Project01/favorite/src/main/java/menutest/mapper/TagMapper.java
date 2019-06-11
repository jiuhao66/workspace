package menutest.mapper;

import menutest.pojo.Tag;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/10 - 19:56
 */
public interface TagMapper {
    /**
     * 新增标签
     * @param tag
     */
    void insNew(Tag tag);

    /**
     * 查询 全部 标签
     * @return
     */
    List<Tag>selAll();


}
