package org.iqqcode.web;


import org.iqqcode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 11:05
 * @Description:DI--Test
 * @DI--构造函数注入
 * @DI--Setter()注入
 */
public class DIClient {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        UserService userService = ac.getBean("userService",UserService.class);
        UserService userServiceII = ac.getBean("userServiceII",UserService.class);
        userService.regist();
        userServiceII.regist();
    }
}
