package yc_spring_test2.com.yc.spring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import yc_spring_test2.com.yc.spring.bbs.bean.User;

/**
 * 注解配置bean 类
 */
@Configuration   // ->  <beans>
@ComponentScan("yc_spring_test2.com.yc.spring")  // 配置spring扫描的包路径
public class BeanConfig {
	
	/**
	 * 创建 Account 对象的方法
	 * @return
	 *//*
	@Bean("accountBiz")
	// <bean id="accountBiz" class="com.yc.spring.bank.biz.impl.AccountBizImplForAnwser"/>
	public AccountBizImplForAnwser createAcountBiz() {
		return new AccountBizImplForAnwser();
	}
	
	//<bean id="account" class="com.yc.spring.bank.bean.Account" primary="true" />
	@Bean("account")
	public Account createAcount() {
		return new Account();
	}
	
	//<bean id="account1" class="com.yc.spring.bank.bean.Account" scope="prototype"></bean>
	@Bean("account1")
	@Scope("prototype")
	public Account createAcount1() {
		return new Account();
	}
	
	@Bean("account2")
	public Account createAcount2() {
		return Account.getInstance();
	}
	
	@Bean("account3")
	public Account createAcount3() {
		return Account.getInstance();
	}*/
	
	/**
	 * 
	 * <bean class="com.yc.spring.bbs.bean.User" primary="true">
		<property name="uname" value="石秀"></property>
		<property name="upass" value="XYZ890"></property>
		<property name="head" value="345.gif"></property>
		<property name="gender" value="0"></property>
	   </bean>
	 * @return
	 */
	@Bean("myUser")
	public User createUser() {
		User user = new User();
		/**
		 * 使用java代码设置属性
		 */
		user.setUname("武松");
		user.setUpass("abc123");
		user.setHead("20.gif");
		user.setGender(1);
		return user;
	}
	
}
