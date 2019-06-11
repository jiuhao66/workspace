import menutest.mapper.DeptMapper;
import menutest.mapper.EmpMapper;
import menutest.pojo.Dept;
import menutest.pojo.Emp;
import menutest.service.DeptBiz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2019/3/3 - 16:09
 */
public class Test {

    public static void main(String[] args) throws IOException {

        /*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        SearchServiceImpl filmInfoMapper = ac.getBean("searchService", SearchServiceImpl.class);

        FilmInfo filmInfo = new FilmInfo();

        System.out.println(666);

        filmInfo.setFilmName("猫和老鼠");

        System.out.println(filmInfoMapper.selectByFilmInfo(filmInfo));*/

        InputStream is = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = factory.openSession();

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        DeptBiz deptBiz = new DeptBiz();

        deptBiz.setDeptMapper(deptMapper);

        deptBiz.setEmpMapper(empMapper);

        Dept dept = new Dept();

        dept.setDname("市场部");

        dept.setLoc("衡阳");

        Emp emp = new Emp();

        deptBiz.addDept(dept,emp);

        sqlSession.commit();

        sqlSession.close();

    }
}
