package com.iqqcode.test;

import com.iqqcode.config.SpringConfiguration;
import com.iqqcode.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 17:48
 * @Description:Spring集成Junit测试--xml&注解
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})

public class SpringJunitTest {

    @Autowired
    private UserService userService;

    //@Resource(name = "dataSource_Druid")  //xml
    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        userService.login();
        System.out.println(dataSource.getConnection());
    }
}
