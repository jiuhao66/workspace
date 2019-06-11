package yc_spring_jdbc_test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yc_spring_jdbc.config.MainConfig;

/**
 * @author LX
 * @date 2019/3/24 - 16:54
 */
public class yc_spring_jdbc_test {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

    @org.junit.Test
    public void test(){

        /*BankService bankService = context.getBean(BankServiceImpl.class);

        Bank bank = new Bank();

        bank.setName("1");

        bank.setPwd("1");

        Bank login = bankService.login(bank);

        System.out.println(login);*/

        context.close();
    }
}
