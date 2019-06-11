package ioc_annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LX
 * @date 2019/5/3 - 17:39
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public int insertUser(){

        jdbcTemplate.update("INSERT INTO user (username,age) VALUES (?,?)");

        return 0;
    }
}
