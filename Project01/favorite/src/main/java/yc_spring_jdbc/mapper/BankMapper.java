package yc_spring_jdbc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yc_spring_jdbc.bean.Bank;

/**
 * @author LX
 * @date 2019/3/24 - 16:46
 */
@Mapper
public interface BankMapper {

    @Select("select * from bank where name = #{name} and pwd = #{pwd}")
    Bank selForLogin(Bank bank);
}
