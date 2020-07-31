package com.iqqcode.service;

import com.iqqcode.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-30 23:17
 * @Description:SpringBoot整合单元测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired //注入userService
    private UserService userService;


    @Test
    public void queryById() {
        User user = userService.queryById(8L);
        System.out.println("user8 = " + user);
    }

    @Test
    public void save() {
        User user = new User();
        user.setUserName("iqqcode");
        user.setName("iqqcode");
        user.setAge(13);
        user.setPassword("123456");
        user.setSex(1);
        user.setCreated(new Date());
        userService.save(user);
    }
}