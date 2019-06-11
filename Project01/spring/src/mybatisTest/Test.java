package mybatisTest;

import menutest.pojo.User;
import menutest.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LX
 * @date 2019/1/30 - 18:00
 */
public class Test {

    public static void main(String[] args) {

       /* ApplicationContext ac = new ClassPathXmlApplicationContext("MybatisApplicationContext.xml");

        TeacherServiceImpl teacherService = ac.getBean("teacherService", TeacherServiceImpl.class);

        List<Teacher> show = teacherService.show();

        System.out.println(show);*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("ShuXingWenJieApplicationContext.xml");

        User user = new User(1,"1","1");

        UserServiceImpl userService = ac.getBean("userService", UserServiceImpl.class);

        System.out.println(userService.login(user));
    }
}
