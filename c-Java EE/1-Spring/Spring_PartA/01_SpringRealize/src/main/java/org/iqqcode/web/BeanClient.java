package org.iqqcode.web;

import org.iqqcode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 11:05
 * @Description:Spring对Bean的管理
 */
public class BeanClient {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        UserService userService = ac.getBean("userService",UserService.class);
        UserService userService1 = ac.getBean("userService",UserService.class);
        System.out.println(userService);
        System.out.println(userService1);
        System.out.println(userService == userService1);
    }
}
