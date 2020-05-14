package org.iqqcode.test;

import org.iqqcode.domain.User;
import org.iqqcode.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-30 11:24
 * @Description:测试xml--CRUD
 */
public class UserServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService us = ac.getBean("userService", UserService.class);
        List<User> users = us.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService us = ac.getBean("userService", UserService.class);
        User user = us.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testSava() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService us = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setName("Java");
        user.setAge(22);
        us.saveUser(user);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService us = ac.getBean("userService", UserService.class);
        User user = us.findUserById(4);
        user.setName("Python");
        us.updateUser(user);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService us = ac.getBean("userService", UserService.class);
        us.deleteUser(4);
    }
}