package yc_spring_test2.com.yc.spring.bbs.dao.impl;

import yc_spring_test2.com.yc.spring.bbs.bean.User;
import yc_spring_test2.com.yc.spring.bbs.dao.UserDao;

import java.util.List;

public class OracleUserDao implements UserDao {

	@Override
	public void insert(User t) {
		System.out.println(String.format("将用户【%s】添加至Oracle数据库", t));
	}

	@Override
	public void update(User t) {
		System.out.println(String.format("修改用户【%s】保存至Oracle数据库", t));
	}

	@Override
	public void delete(User t) {
		System.out.println(String.format("删除Oracle数据库中的用户【%s】", t));
	}

	@Override
	public void selectOne(Object id) {
		System.out.println(String.format("从Oracle数据库中的查找用户id：%s", id));
	}

	@Override
	public List<User> selectList(User t, Integer page, Integer rows) {
		System.out.println(String.format("从Oracle数据库中的分页查找用户：%s", t));
		return null;
	}

	@Override
	public long count(User t) {
		System.out.println(String.format("从Oracle数据库中统计用户数量：%s", t));
		return 0;
	}

}
