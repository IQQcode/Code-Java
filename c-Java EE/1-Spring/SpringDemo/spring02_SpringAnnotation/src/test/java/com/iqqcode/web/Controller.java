package com.iqqcode.web;

import com.iqqcode.config.SpringConfiguration;
import com.iqqcode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 00:43
 * @Description:
 */
public class Controller {
    public static void main(String[] args) {
        //xml配置文件
        //ApplicationContext apps = new ClassPathXmlApplicationContext("applicationContext.xml");

        //=================================================================================//

        //Annotation-Config
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //根据id获取Bean
        UserService userService = app.getBean(UserService.class);
        userService.login();
    }
}