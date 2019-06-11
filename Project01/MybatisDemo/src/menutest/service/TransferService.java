package menutest.service;

import menutest.pojo.Account;

/**
 * @author LX
 * @date 2018/11/18 - 18:03
 */
public interface TransferService {
    int transfer(Account out, Account in) ;

    int AMOUNT_NO_ENOUGH=1;  // 转人员余额不足
    int SUCCESS=6;   //  转账成功
    int ACCOUNT_PWD_ERROR=2;//账号 错误
    int SYSTEM_ERROR=3;//系统内部错误
    int DATABASE_ERROR=4;// 数据更新错误
}
