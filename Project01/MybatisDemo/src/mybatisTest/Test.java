package mybatisTest;

import menutest.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2018/11/16 - 21:24
 */
public class Test {
    public static void main(String[] args) throws IOException {


        InputStream is = Resources.getResourceAsStream("mapper.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = factory.openSession();

        //TeacherMapper menutest.mapper = session.getMapper(TeacherMapper.class);

        System.out.println("hello  word");

         StudentMapper mapper = session.getMapper(StudentMapper.class);


        System.out.println(mapper.selByid(1));


    }
}
