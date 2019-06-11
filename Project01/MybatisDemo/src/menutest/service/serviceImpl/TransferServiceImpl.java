package menutest.service.serviceImpl;

import menutest.pojo.Account;
import menutest.pojo.Bank;
import menutest.service.TransferService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @date 2018/11/18 - 18:05
 */
public class TransferServiceImpl implements TransferService {
    @Override
    public int transfer(Account out, Account in) {

        //  获取了    收款人的信息  和  付款人的信息基本信息
        InputStream is = null;

        try {

            is = Resources.getResourceAsStream("mapper.xml");

        } catch (IOException e) {

           // 系统内部出错
            return SYSTEM_ERROR;

        }

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            SqlSession session=factory.openSession();

            // 先判断账号是否正确
            Bank outStr = session.selectOne("mapper.BankMapperImpl.selByIdPwd", out);

            if(outStr!=null){

                //转钱账号正确
                if(out.getAmount()>outStr.getBalance()){

                    // 转账人员的余额不够
                    return AMOUNT_NO_ENOUGH;

                }else{

                    //余额足够
                    //将转钱的余额输入到 转入的人里面
                    in.setAmount(out.getAmount());

                    Bank inStr=session.selectOne("menutest.mapper.BankMapperImpl.selByIdName",in);

                    if(inStr!=null){

                        //转入账号正确
                        //开始转钱
                        in.setAmount(out.getAmount());

                        int outIndex= session.update("menutest.mapper.BankMapperImpl.updBalanceByIdPwd",out);

                        int inIndex=session.update("menutest.mapper.BankMapperImpl.updBalanceByIdName",in);

                        if((outIndex+inIndex)==2){

                            // 转账成功
                            session.commit();

                            return SUCCESS;

                        }else{

                            session.rollback();

                            session.close();

                            return DATABASE_ERROR;
                        }

                    }else{

                        // 输入账号出错
                        return ACCOUNT_PWD_ERROR;
                    }
                }
            }else{

                // 转账人员账号错误
                return ACCOUNT_PWD_ERROR;

            }
    }
}
