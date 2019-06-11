package menutest.service.impl;

import menutest.mapper.UserMapper;
import menutest.pojo.User;
import menutest.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/2/26 - 20:55
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    /* 从 属性文件快速取出 值   */
    @Value("${my.test}")
    private String name;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {

        System.out.println(name);
        return userMapper.selByUser(user);
    }
}
