package com.iqqcode.test;

import com.iqqcode.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-04 23:00
 * @Description:单元测试类
 */
public class SpringTest {
    @Test
    //测试scope属性-无参构造
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1 == userDao2);
    }

    //工厂静态方法创建Bean对象
    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("static_factory");
        UserDao userDao2 = (UserDao) app.getBean("static_factory");
        System.out.println(userDao1 == userDao2);
    }

    //工厂实例方法创建Bean对象
    @Test
    public void test3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("instance_factory");
        UserDao userDao2 = (UserDao) app.getBean("instance_factory");
        System.out.println(userDao1 == userDao2);
    }
}
