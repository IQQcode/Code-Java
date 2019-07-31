package com.ming;


import com.ming.bean.Person;
import com.ming.bean.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest2 {

    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testMethod(){
        UserInfo userInfo = (UserInfo) applicationContext.getBean("userinfo");
        System.out.println("pName = " + userInfo.getPerson().getpName());
    }
}
