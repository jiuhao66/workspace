package yc_spring_jdbc.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author LX
 * @date 2019/3/24 - 15:34
 */
@Configuration
/*@ComponentScan(value = "yc_spring_jdbc" ,includeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION ,classes = {Component.class, Resource.class,
                Autowired.class, Service.class,Conditional.class, Controller.class})
},useDefaultFilters = false )*/
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:db.properties")
public class MainConfig {

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.driver}")
    private String driver;
    /**
     * 配置  jdbc 数据 信息
     * @return
     */
    @Bean
    public DataSource dataSource(){

        PooledDataSource dataSource = new PooledDataSource();

        dataSource.setPassword(password);

        dataSource.setUsername(username);

        dataSource.setUrl(url);

        dataSource.setDriver(driver);

        return dataSource;
    }

    /**
     * 为mybatis  创建一个  SqlSessionFactory
     *  并且把 数据信息传入进去  为他 指明 pojo 包的 基础名
     *
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource) throws SQLException {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);

        sqlSessionFactoryBean.setTypeAliasesPackage("yc_spring_jdbc.bean");

        return  sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        mapperScannerConfigurer.setBasePackage("yc_spring_jdbc.mapper");

        return mapperScannerConfigurer;
    }
}
