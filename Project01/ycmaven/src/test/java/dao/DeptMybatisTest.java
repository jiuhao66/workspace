package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2019/3/2 - 15:02
 */
public class DeptMybatisTest {

    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("mybatis.xml");

        /*InputStream is = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        List<Dept> depts = mapper.selAll();

        System.out.println(depts.toString());*/

    }
}
