package ioc_annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/5/3 - 17:39
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int insertUser(){

        return 0;
    }
}
