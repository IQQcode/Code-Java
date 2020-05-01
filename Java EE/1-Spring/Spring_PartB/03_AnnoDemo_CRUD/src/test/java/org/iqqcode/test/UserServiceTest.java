package org.iqqcode.test;

import org.iqqcode.config.SpringConfiguration;
import org.iqqcode.domain.User;
import org.iqqcode.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-30 11:24
 * @Description:使用Junit单元测试
 */
public class UserServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService us = ac.getBean("userService",UserService.class);
        List<User> users = us.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}