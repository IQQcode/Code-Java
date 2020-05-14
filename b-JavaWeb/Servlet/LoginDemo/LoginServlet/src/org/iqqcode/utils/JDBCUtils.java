package org.iqqcode.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-09 10:31
 * @Description:JDBC工具类,使用druid连接池
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties props = new Properties();

            //使用ClassLoader加载配置文件来获取字节输入流
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            props.load(inputStream);

            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(props);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取Connection对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
