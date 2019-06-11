package yc_spring_jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc_spring_jdbc.bean.Bank;
import yc_spring_jdbc.mapper.BankMapper;
import yc_spring_jdbc.service.BankService;

/**
 * @author LX
 * @date 2019/3/24 - 16:52
 */
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;

    @Override
    public Bank login(Bank bank) {

        System.out.println(bankMapper);

        return bankMapper.selForLogin(bank);
    }
}
