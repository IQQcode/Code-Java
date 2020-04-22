package com.iqqocde.pretreatment;

import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 18:49
 * @Description:JDBC-Select
 */
public class PretreatmentTest {
    @Test
    public void testSelect() throws SQLException {
        Connection coon = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbctest", "root", "1234");
            //3.执行SQL
            String sql = "select * from user";
            stmt = coon.createStatement();
            //查询的结果通过 ResultSet 放入到结果集中
            resultSet = stmt.executeQuery(sql);

            //遍历结果集
            while(resultSet.next()) {
                //每一行记录认为是一个对象
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String age = resultSet.getString("age");
                String sex = resultSet.getString("sex");
                System.out.println("----------------------------------");
                System.out.println("id : "+id+" \nusername : "+username +"\npassword : "+password +"\nage : "+age+"\nsex : "+sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            coon.close();
            stmt.close();
            resultSet.close();
        }
    }
}
