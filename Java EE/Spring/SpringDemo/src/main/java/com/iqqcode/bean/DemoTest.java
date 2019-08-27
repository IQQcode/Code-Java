package com.iqqcode.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 08:34
 * @Description:
 */

public class DemoTest {
    /**
     * UserInfo class helloWord function will be called by DemoTest
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //创建IoC容器并使用 Bean

        //从 Spring的容器中获取 文件applicationContext.xml
        ApplicationContext context =
                null;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // getBean()返回的是 Object

        UserInfo userInfo = (UserInfo) context.getBean("userInfo");
        String result = userInfo.helloWorld();
        System.out.println(result);
    }
}
