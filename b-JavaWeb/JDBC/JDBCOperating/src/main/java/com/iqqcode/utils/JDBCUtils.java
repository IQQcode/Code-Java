package com.iqqcode.utils;

import	java.sql.ResultSet;
import	java.sql.Statement;
import	java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import	java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 21:22
 * @Description:JDBC工具类
 */
public class JDBCUtils {
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties ps = CommUtils.loadProperties("db.properties");
        driverName = ps.getProperty("driverName");
        url = ps.getProperty("url");
        username = ps.getProperty("username");
        password = ps.getProperty("password");

        //加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2.获取数据库连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("数据库连接出错！");
        }
        return null;
    }

        public static void closeResources(Connection conn,
                Statement stmt) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    // OverLoading
    public static void closeResources(Connection coon, Statement stmt,ResultSet resultSet) {
        closeResources(coon, stmt);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
