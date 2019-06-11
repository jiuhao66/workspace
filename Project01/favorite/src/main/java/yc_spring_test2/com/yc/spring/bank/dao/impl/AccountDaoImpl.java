package yc_spring_test2.com.yc.spring.bank.dao.impl;

import org.apache.ibatis.session.SqlSession;
import yc_spring_test2.com.yc.spring.bank.bean.Account;
import yc_spring_test2.com.yc.spring.bank.dao.AccountDao;

/**
 * 账号Dao实现类
 */
//@Repository
public class AccountDaoImpl implements AccountDao {
	
	private SqlSession session;

	@Override
	public void insert(Account t) {
		AccountDao dao = session.getMapper(AccountDao.class);
		dao.insert(t);
	}

	@Override
	public void update(Account t) {
		AccountDao dao = session.getMapper(AccountDao.class);
		dao.update(t);
	}

	@Override
	public Account selectById(Integer id) {
		AccountDao dao = session.getMapper(AccountDao.class);
		return dao.selectById(id);
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}
}
