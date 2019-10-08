package org.iqqcode.utils;


import	java.sql.ResultSet;
import	java.sql.Statement;
import	java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import	java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 08:48
 * @Description:封装JDBC操作的公共方法
 */
public class JDBCUtils {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String password;

    // static code block,when the class load to Call once
    static {
        Properties prop = CommUtils.loadProperties("db.properties");
        driverName = prop.getProperty("driverName");
        url = prop.getProperty("url");
        userName = prop.getProperty("username");
        password = prop.getProperty("password");

        // 1.加载驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("加载数据库出错");
        }
    }

    // 2.获取数据库连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("数据库连接出错！");
        }
        return null;
    }

    /**
     * 3.关闭数据库资源操作
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeResources(Connection connection,
                                      Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // OverLoading
    public static void closeResources(Connection connection,
                                      Statement statement,ResultSet resultSet) {

        closeResources(connection, statement);

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
