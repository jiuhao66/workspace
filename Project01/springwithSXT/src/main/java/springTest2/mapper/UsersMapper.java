package springTest2.mapper;

import org.apache.ibatis.annotations.Select;
import springTest2.pojo.Users;

/**
 * @author LX
 * @date 2019/3/13 - 21:14
 */
public interface UsersMapper {

    @Select("select * from users where username=#{username} and password=#{password}")
    Users selByPWD(Users  users);

    int insUsers(Users users);
}
