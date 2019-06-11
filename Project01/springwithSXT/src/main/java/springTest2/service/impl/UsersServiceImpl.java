package springTest2.service.impl;

import org.springframework.stereotype.Service;
import springTest2.mapper.UsersMapper;
import springTest2.pojo.Users;
import springTest2.service.UsersService;

import javax.annotation.Resource;

/**
 * @author LX
 * @date 2019/3/13 - 21:23
 */

@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users selByLogin(Users users) {

        return usersMapper.selByPWD(users);
    }

    @Override
    public int insUser(Users users) {

        return usersMapper.insUsers(users);
    }
}
