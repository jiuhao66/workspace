package yc_spring_test2.com.yc.spring.bank.dao.impl;

import org.apache.ibatis.session.SqlSession;
import yc_spring_test2.com.yc.spring.bank.bean.Record;
import yc_spring_test2.com.yc.spring.bank.dao.RecordDao;

import java.util.List;

/**
 * 账号流水Dao实现类
 */
//@Repository
public class RecordDaoImpl implements RecordDao {

	private SqlSession session;
	
	@Override
	public void insert(Record t) {
		RecordDao dao = session.getMapper(RecordDao.class);
		dao.insert(t);
	}

	@Override
	public void update(Record t) {
		RecordDao dao = session.getMapper(RecordDao.class);
		dao.update(t);
	}

	@Override
	public Record selectById(Integer id) {
		RecordDao dao = session.getMapper(RecordDao.class);
		return dao.selectById(id);
	}

	@Override
	public List<Record> selectByAccountId(Integer id) {
		RecordDao dao = session.getMapper(RecordDao.class);
		return dao.selectByAccountId(id);
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

}
