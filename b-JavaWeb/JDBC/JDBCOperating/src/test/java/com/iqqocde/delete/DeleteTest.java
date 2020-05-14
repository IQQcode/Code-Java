package com.iqqocde.delete;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 18:49
 * @Description:JDBC-Delete
 */
public class DeleteTest {
    @Test
    public void testDelete() throws SQLException {
        Connection coon = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbctest", "root", "1234");
            //3.执行SQL
            String sql = "delete from user where id = 11";
            stmt = coon.createStatement();
            int effectRows = stmt.executeUpdate(sql);
            System.err.println("影响行数： " + effectRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            coon.close();
            stmt.close();
        }
    }
}
