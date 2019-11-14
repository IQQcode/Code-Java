package com.jdbc.basic;

import com.jdbc.utils.CommUtils;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-11 19:33
 * @Description:
 */
public class JDBCProperties {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        /*Properties properties = CommUtils.LoadProperties("db.properties");
        String URL = properties.getProperty("URL");
        String USERNAME = properties.getProperty("USERNAME");
        String PASSWORD = properties.getProperty("PASSWORD");*/
        String URL = "jdbc:mysql://localhost:3306/test";
        String USERNAME = "root";
        String PASSWORD = "1234";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);

            String sql = "select * from student";

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
            //遍历结果集
            while (resultSet.next()) {
                //每一行记录认为是一个对象
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String major = resultSet.getString("major");
                System.out.println("id : "+id+" \nname : "+name +"\nage : "+age +"\nmajor : "+major);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
