package ioc_annotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile :
 *   Spring为我们提供的 可以根据当前环境,动态的激活和切换一系列组件的功能
 *   1: 加了环境的标识的bean ,只有这个环境被激活的时候才能注册到容器中
 *   默认是   default
 *
 *   组件写在 类上  只有在指定的环境的时候 , 整个配置类里面的所有的配置才能生效
 *   没有 标注 环境标识的bean在任何环境下都是加载的 ,
 *
 *   开发环境  .测试环境 生产环境
 *   数据源 :(/A) (/B)
 *
 *
 * @author LX
 * @date 2019/3/19 - 21:23
 */
@PropertySource("classpath:/profileDB.properties")
@Configuration
public class MainConfigProfile implements EmbeddedValueResolverAware{

    @Value("${jdbc.username}")
    private String userName;

    private String driverClass;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("jdbc.password") String password) throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(userName);

        dataSource.setPassword(password);

        dataSource.setJdbcUrl("jdbc.url=jdbc:mysql://localhost:3306/spring_annotation");

        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(userName);

        dataSource.setPassword("a");

        dataSource.setJdbcUrl("jdbc.url=jdbc:mysql://localhost:3306/spring_annotation");

        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(userName);

        dataSource.setPassword("a");

        dataSource.setJdbcUrl("jdbc.url=jdbc:mysql://localhost:3306/sxt");

        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

        String stringValue = stringValueResolver.resolveStringValue("${jdbc.driver}");

        this.driverClass = stringValue;
    }
}
