package yc_spring_test2.com.yc.spring.bank.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import yc_spring_test2.com.yc.spring.bank.bean.Record;

import java.util.List;

public interface RecordDao extends BaseDao<Record>{
	@Override
	@Update("insert into bank_record values(null, #{accountId}, #{money})")
	void insert(Record t);

	@Select("select * from bank_record where accountid=#{accountId}")
	List<Record> selectByAccountId(Integer id);
}
