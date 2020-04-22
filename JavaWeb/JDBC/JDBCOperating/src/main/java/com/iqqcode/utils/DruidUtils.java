package com.iqqcode.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 21:47
 * @Description: 基于Alibaba DruidDataSource
 */
public class DruidUtils {
    private static DruidDataSource dataSource;

    // 注册驱动，相当于创建数据库的连接池
    static {
        Properties props = CommUtils.loadProperties("druid.properties");
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            System.err.println("获取数据源失败！");
        }
    }

    // 获取连接
    public static DruidPooledConnection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("获取连接失败！！");
        }
        return null;
    }

    // 释放资源
    public static void close(Connection coon,
                             Statement stmt) {
        if(coon != null) {
            try {
                coon.close();
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

    public static void close(Connection coon,
                             Statement stmt, ResultSet resultSet) {
        close(coon, stmt);

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
