package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2018/11/26 - 19:44
 */
public class MybatisUtils {

    private static SqlSessionFactory factory;

    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();

    static{

        try {

            InputStream is = Resources.getResourceAsStream("mapper.xml");

            factory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }
    }
    /**
     * 获取SqlSession的方法
     */
    public static SqlSession getSession(){

        SqlSession session = tl.get();

        if(session==null){

            tl.set(factory.openSession());
        }

        return tl.get();
    }

    public static void closeSession(){

        SqlSession session = tl.get();

        if(session!=null){

            session.close();
        }

        tl.set(null);
    }
}
