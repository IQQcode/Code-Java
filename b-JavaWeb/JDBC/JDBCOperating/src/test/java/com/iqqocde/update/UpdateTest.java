package com.iqqocde.update;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 18:49
 * @Description:JDBC-Update
 */
public class UpdateTest {
    @Test
    public void testUpdate() throws SQLException {
        Connection coon = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql:///db_jdbctest","root","1234");
            String sql = "update user set username = 'Jack' where id = 3";
            stmt = coon.createStatement();
            int effectRows = stmt.executeUpdate(sql);
            System.err.println("影响行数： " + effectRows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //4.释放资源
            coon.close();
            stmt.close();
        }
    }
}
