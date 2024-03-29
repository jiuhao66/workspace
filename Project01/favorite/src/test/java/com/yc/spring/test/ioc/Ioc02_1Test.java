package com.yc.spring.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yc_spring_test2.com.yc.spring.bank.bean.Account;
import yc_spring_test2.com.yc.spring.bbs.bean.User;
import yc_spring_test2.com.yc.spring.ioc.BeanConfig;

/**
 * 配置Spring，让测试方法全部测试通过
 */
public class Ioc02_1Test {
	// 创建注解容器上下文对象
	ApplicationContext cxt = new AnnotationConfigApplicationContext(BeanConfig.class);
	
	@Test
	public void test1() {
		Account a = cxt.getBean(Account.class);
		Account b = cxt.getBean(Account.class);
		Account c = (Account) cxt.getBean("account");
		Assert.assertEquals(a, b);  // a == b
		Assert.assertEquals(c, b);	// c == b
	}

	@Test
	public void test2() {
		Account a = (Account) cxt.getBean("account1");
		Account b = (Account) cxt.getBean("account1");
		Account c = (Account) cxt.getBean("account1");
		Assert.assertNotEquals(a, b);
		Assert.assertNotEquals(c, b);
		Assert.assertNotEquals(c, a);
	}
	
	@Test
	public void test3() {
		Account a1 = (Account) cxt.getBean("account2");
		Account a2 = (Account) cxt.getBean("account2");
		Account a3 = (Account) cxt.getBean("account3");
		Account a4 = (Account) cxt.getBean("account3");
		Assert.assertEquals(a1, a2);
		Assert.assertEquals(a3, a4);
		
		Assert.assertEquals(a1, a3);
		Assert.assertEquals(a2, a4);
	}
	
	/**
	 * 坑。。。
	 */
	@Test
	public void test4() {
		Account a1 = (Account) cxt.getBean("account4");
		Account a2 = (Account) cxt.getBean("account4");
		Account a3 = (Account) cxt.getBean("account4");
		Account a4 = (Account) cxt.getBean("account4");
		Account a5 = (Account) cxt.getBean("account4");
		Account a6 = (Account) cxt.getBean("account4");
		Account a7 = (Account) cxt.getBean("account4");
		
		Assert.assertNotEquals(a1, a2);
		Assert.assertNotEquals(a1, a3);
		Assert.assertNotEquals(a1, a4);
		Assert.assertEquals(a4, a5);
		Assert.assertEquals(a4, a6);
		Assert.assertEquals(a4, a7);
	}
	
	
	@Test
	public void test5() {
		System.out.println();
		User user = (User) cxt.getBean("myUser");
		Assert.assertNotNull(user);
		Assert.assertEquals("武松", user.getUname());
		Assert.assertEquals("abc123", user.getUpass());
		Assert.assertEquals("20.gif", user.getHead());
		Assert.assertEquals(Integer.valueOf(1), user.getGender());
	}


	
}
