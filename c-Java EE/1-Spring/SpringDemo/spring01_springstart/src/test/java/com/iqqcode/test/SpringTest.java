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
    //测试scope属性
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1 == userDao2);
    }

    @Test
    public void test2() {

    }
}
