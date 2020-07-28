package com.iqqcode;

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
        // 1.根据id获取Bean
        UserService userService = (UserService) apps.getBean("userService");
        // 2.根据类型获取Bean(多个相同类型的无法使用，只能用id)
        //UserService userService = apps.getBean(UserService.class);
        userService.save();
    }
}
