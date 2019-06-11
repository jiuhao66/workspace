package ioc_annotation.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *
 * 声明式 事物
 *    1：导入相关依赖
 *         数据源。数据库驱动，spring-Jdbc模块
 *    2:配置数据源: JdbcTemplate (Spring提供的简化数据库操作的工具) 操作数据
 *
 *    3: 给方法上面标注: @Transactional 表示当前方法是一个事物方法
 *
 *    4: @EnableTransactionManagement 开启基于注解的事物管理器
 * @author LX
 * @date 2019/4/7 - 17:16
 */
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("ioc_annotation.tx")
@EnableTransactionManagement
public class TxConfig {

    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setPassword(password);

        dataSource.setJdbcUrl(url);

        dataSource.setDriverClass(driver);

        dataSource.setUser(username);

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() throws PropertyVetoException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
