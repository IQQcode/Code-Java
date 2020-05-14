package com.iqqocde.insert;

import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 18:49
 * @Description:JDBC-Insert
 */
public class InsertTest {
    @Test
    public void testInsert() throws SQLException {
        Connection coon = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbctest", "root", "1234");
            //3.执行SQL
            String sql = "insert into user(username,password,age,sex) values ('Tom','1234','18','男')";
            stmt = coon.createStatement();
            int effectRows = stmt.executeUpdate(sql);
            System.out.println(effectRows);
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
