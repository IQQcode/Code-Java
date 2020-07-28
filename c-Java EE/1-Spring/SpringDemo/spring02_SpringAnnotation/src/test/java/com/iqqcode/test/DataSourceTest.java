package com.iqqcode.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 13:53
 * @Description:连接数据源测试
 */

public class DataSourceTest {
    @Test
    //测试Druid数据源--配置文件(EL表达式外部加载)
    public void test4() throws Exception {
        //Spring读取配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //有两个数据源，不能采用反射对象的方式读取
        DataSource dataSource = (DataSource) app.getBean("dataSource_Druid");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试Druid数据源
    public void test3() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_test");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试c3p0数据源--配置文件
    public void test2() throws Exception {
        //Spring读取配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource_c3p0");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试c3p0数据源
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db_test");
        dataSource.setUser("root");
        dataSource.setPassword("1234");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
