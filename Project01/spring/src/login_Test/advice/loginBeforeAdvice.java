package login_Test.advice;

import menutest.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author LX
 * @date 2019/2/26 - 21:29
 */
public class loginBeforeAdvice implements MethodBeforeAdvice {


                                      // 参数
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        User user =(User)objects[0];

        Logger logger = Logger.getLogger(loginBeforeAdvice.class);

        logger.info(user.getUsername()+"  "+ new Date().toLocaleString()+" 登录");


    }
}
