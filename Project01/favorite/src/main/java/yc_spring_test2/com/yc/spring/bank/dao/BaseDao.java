package yc_spring_test2.com.yc.spring.bank.dao;

import org.apache.ibatis.session.SqlSession;

public interface BaseDao <T>{
	
	void insert(T t);
	
	void update(T t);
	
	T selectById(Integer id);
	
	void setSession(SqlSession session);
	
}
