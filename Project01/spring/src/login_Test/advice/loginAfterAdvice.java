package login_Test.advice;

import menutest.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author LX
 * @date 2019/2/26 - 21:30
 */
public class loginAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        User user = (User) objects[0];

        Logger logger = Logger.getLogger(loginAfterAdvice.class);

        if(o != null){

            logger.info(user.getUsername()+ "  "+new Date().toLocaleString()+ "登录成功");
        }else{
            logger.info(user.getUsername()+ "  "+new Date().toLocaleString()+ "登录失败");

        }


    }
}
