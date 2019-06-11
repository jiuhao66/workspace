package mybatisTest;

import menutest.mapper.BankMapper;
import menutest.pojo.Bank;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author LX
 * @date 2018/11/16 - 19:37
 */
public class MybatisTest {
    public static void main(String[] args) {

        SqlSession session=null;

        InputStream is= null;

        try {

            is = Resources.getResourceAsStream("mapper.xml");

        } catch (IOException e) {

            e.printStackTrace();
        }

        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(is);

        session =factory.openSession();

        BankMapper mapper = session.getMapper(BankMapper.class);  // 通过这个名字 去 解析相应的  xml文件

        List<Map> list = mapper.selAll();

        mapper.selAll();

        Bank bank=mapper.selById(1);


        System.out.println(bank.getBalance());

        String name="zhang";

        bank=mapper.selByIdName(2,name);

        bank=mapper.selByIdName(2,name);

        System.out.println(bank.toString());

        System.out.println(list.get(0).get("balance")+"  "+list.size());


       /* List<Integer>list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Bank> banks = menutest.mapper.selIn(list1);
        System.out.println(banks.toString());*/
        session.close();
    }
}
