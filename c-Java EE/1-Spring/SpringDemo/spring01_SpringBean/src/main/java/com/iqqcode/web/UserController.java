package com.iqqcode.web;

import com.iqqcode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 00:43
 * @Description:
 */
public class UserController {
    public static void main(String[] args) {
        ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) apps.getBean("userService");
        userService.save();
    }
}
