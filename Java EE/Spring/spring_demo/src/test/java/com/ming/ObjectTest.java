package com.ming;


import com.ming.bean.Person;
import com.ming.bean.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest {

    /**
     * Spring API(Application Interface)
     *
     */
    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testMethod(){
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.sayHello("michael"));
        System.out.println("pName = " + person.getpName());
    }
}
