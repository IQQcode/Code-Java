package com.jdbc.basic;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-08 16:05
 * @Description:jdbc连接数据库基础操作
 */
public class JDBCBasicDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.导入驱动jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 3.获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
        // 4.定义SQL语句
        String sql = "select * from student";
        // 5.获取执行SQL的对象 Statement
        Statement statement = connection.createStatement();
        // 6.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);
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
        connection.close();
        statement.close();
    }
}
