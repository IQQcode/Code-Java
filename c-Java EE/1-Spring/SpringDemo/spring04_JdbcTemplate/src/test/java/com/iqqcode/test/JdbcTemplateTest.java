package com.iqqcode.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-29 10:37
 * @Description:
 */
public class JdbcTemplateTest {

    @Test
    //测试Spring产生JdbcTemplate模板对象
    public void test_template() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int rows = jdbcTemplate.update("insert into account values (?, ?)", "李四", 5000);
        System.out.println(rows);
    }

    @Test
    //测试JdbcTemplate开发步骤
    public void test_jdbc() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_test");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        // 1.创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 2.设置数据源对象
        jdbcTemplate.setDataSource(dataSource);
        // 3.执行操作
        int rows = jdbcTemplate.update("insert into account values (?, ?)", "iqqode", 2021);
        System.out.println(rows);
    }
}
