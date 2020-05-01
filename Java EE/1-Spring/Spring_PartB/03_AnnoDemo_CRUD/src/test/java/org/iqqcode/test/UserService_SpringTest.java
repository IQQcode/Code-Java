package org.iqqcode.test;

import org.iqqcode.config.SpringConfiguration;
import org.iqqcode.domain.User;
import org.iqqcode.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-30 11:24
 * @Description:使用Spring-Junit单元测试
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的@Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserService_SpringTest {

    @Autowired
    private UserService us = null;

    @Test
    public void testFindAll() {
        List<User> users = us.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        User user = us.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testSava() {
        User user = new User();
        user.setName("Java");
        user.setAge(22);
        us.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = us.findUserById(4);
        user.setName("Python");
        us.updateUser(user);
    }

    @Test
    public void testDelete() {
        us.deleteUser(4);
    }
}