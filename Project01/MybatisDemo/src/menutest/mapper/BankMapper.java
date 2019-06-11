package menutest.mapper;

import menutest.pojo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LX
 * @date 2018/11/25 - 15:58
 */
public interface BankMapper {
    List<Map> selAll();
    Bank selById(@Param("id") int id);
    Bank selByIdName( @Param("id") int id, @Param("name") String name);

    List<Bank> selIn(List<Integer> list);
}
