package dao;

import java.sql.*;

/**
 * @author LX
 * @date 2018/11/13 - 0:38
 */
public class ClobTestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt","root","a");

        System.out.println(conn);

    }
}
