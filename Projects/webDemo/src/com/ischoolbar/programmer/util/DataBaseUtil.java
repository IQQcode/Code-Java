package com.ischoolbar.programmer.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;

/**
 *
 * @author Mr.Q
 * 数据库的链接封装util
 */
public class DataBaseUtil {

    //数据库链接信息
    private String dbUrl = "jdbc:mysql://localhost:3306/db_student_management?useUnicode=true&characterEncoding=utf8";
    private String dbUser = "root";       //用户名
    private String dbPassword = "1234";   //密码
    private String jdbcName = "com.mysql.jdbc.Driver";
    private Connection connection = null;
    public Connection getConnection(){
        try {
            Class.forName(jdbcName);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("数据库链接成功！");

        } catch (Exception e) {
            System.out.println("数据库链接失败！");
            e.printStackTrace();

        }
        return connection;
    }

    //关闭数据库链接
    public void closeCon(){
        if(connection != null)
            try {
                connection.close();
                System.out.println("数据库链接已关闭！");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        dataBaseUtil.getConnection();
    }
}

