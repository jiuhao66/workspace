package springTest2.service;

import springTest2.pojo.Users;

/**
 * @author LX
 * @date 2019/3/13 - 21:20
 */

public interface UsersService {

    Users selByLogin(Users users);

    int insUser(Users users);

}
