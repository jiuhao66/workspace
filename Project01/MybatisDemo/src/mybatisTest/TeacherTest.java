package mybatisTest;

import menutest.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2019/1/25 - 21:13
 */
public class TeacherTest {

    public static void main(String[] args) throws IOException {

        InputStream is = Resources.getResourceAsStream("mapper.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = factory.openSession();

        TeacherMapper mapper = session.getMapper(TeacherMapper.class);

        System.out.println(mapper.selBytidTosid(1));

    }
}
