package com.yc.spring.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yc_spring_test2.com.yc.spring.bbs.bean.User;
import yc_spring_test2.com.yc.spring.bbs.biz.UserBiz;

/**
 * 配置Spring，让测试方法全部测试通过
 */
public class Ioc04Test {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Ioc03.xml");

	@Test
	public void test1() {
		UserBiz ubiz = context.getBean(UserBiz.class);
		ubiz.create(new User());
	}

}
