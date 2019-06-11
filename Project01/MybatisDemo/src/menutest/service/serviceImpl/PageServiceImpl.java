package menutest.service.serviceImpl;

import menutest.pojo.PageInfo;
import menutest.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LX
 * @date 2018/11/17 - 20:05
 */
public class PageServiceImpl implements service.PageService {
    @Override
    public PageInfo showUser(int pageSize, int pageNumber) throws IOException {

        //查询数据   跟着pageSize  和pageNumber 来查询
        Map<String,Object> map=new HashMap<String, Object>();

        InputStream is = Resources.getResourceAsStream("mapper.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session=factory.openSession();

        //menutest.mapper.UserMapperImpl
        map.put("pageStart",pageSize*(pageNumber-1));

        map.put("pageSize",pageSize);

       // selByLimit  selAllCount
        List<User> list=session.selectList("menutest.mapper.UserMapperImpl.selByLimit",map);

        long total = session.selectOne("menutest.mapper.UserMapperImpl.selAllCount");

        PageInfo pageInfo=new PageInfo(pageSize,pageNumber,total,list);

        return pageInfo;

    }
}
