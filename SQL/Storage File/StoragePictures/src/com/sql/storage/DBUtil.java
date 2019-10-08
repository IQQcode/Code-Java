package com.sql.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-07 23:07
 * @Description:
 */
public class DBUtil {
    // 定义数据库连接参数
    //加载驱动
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    //指定连接路径:   IP  端口  数据库名称
    //localhost:本机回环地址 127.0.0.1
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    //本机的 mysql服务器可简写为: jdbc:mysql:///test
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

    // 静态块注册数据库驱动
    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("注册失败！");
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 关闭连接
    public static void closeConn(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭连接失败！");
                e.printStackTrace();
            }
        }
    }
    //测试
    public static void main(String[] args) throws SQLException {
        System.out.println(DBUtil.getConn());
    }

}