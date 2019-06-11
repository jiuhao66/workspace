package bean_annotation_test;

import ioc_annotation.config.MainConfigProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author LX
 * @date 2019/3/19 - 21:52
 */
public class IOC_Profile_Test {

   // 使用命令行动态参数: 在虚拟机参数加载 -Dspring.profiles.active=test
  // 用代码 方式激活环境
    @Test
   public void test(){

        // 1 创建一个 application
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 2 设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test","dev");

        //3 注册 主配置类
        context.register(MainConfigProfile.class);

        //4 启动刷新容器
        context.refresh();

       String[] names = context.getBeanNamesForType(DataSource.class);

       for (String name : names){

           System.out.println(name);
       }

       context.close();
   }
}
