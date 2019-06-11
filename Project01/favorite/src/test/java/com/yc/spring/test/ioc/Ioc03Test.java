package com.yc.spring.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yc_spring_test2.com.yc.spring.bank.bean.Account;
import yc_spring_test2.com.yc.spring.bank.bean.Record;

/**
 * 配置Spring，让测试方法全部测试通过
 */
public class Ioc03Test {

	@Test
	public void test1() {

		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext("BeanConfig.class");

		Account a = cxt.getBean(Account.class);
		Assert.assertEquals("吴用", a.getName());
		Assert.assertEquals((Integer) 100, a.getId());
		Assert.assertEquals((Double) 12.2, a.getMoney());

		Record b = cxt.getBean(Record.class);
		Assert.assertEquals((Integer) 100, b.getAccountId());
		Assert.assertEquals((Double) 2.22, b.getMoney());

		cxt.close();

	}

	@Test
	public void test2() {

		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("IOC02.xml");

		Account a = cxt.getBean(Account.class);
		Assert.assertEquals("吴用", a.getName());
		Assert.assertEquals((Integer) 100, a.getId());
		Assert.assertEquals((Double) 12.2, a.getMoney());

		Record b = cxt.getBean(Record.class);
		Assert.assertEquals((Integer) 100, b.getAccountId());
		Assert.assertEquals((Double) 2.22, b.getMoney());

		cxt.close();

	}

}
