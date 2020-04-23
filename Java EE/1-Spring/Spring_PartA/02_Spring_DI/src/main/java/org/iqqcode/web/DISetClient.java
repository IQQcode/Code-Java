package org.iqqcode.web;


import org.iqqcode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 11:05
 * @Description:DI--注入集合数据
 */
public class DISetClient {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        UserService userServiceIII = ac.getBean("userServiceIII",UserService.class);
        userServiceIII.regist();
    }
}
