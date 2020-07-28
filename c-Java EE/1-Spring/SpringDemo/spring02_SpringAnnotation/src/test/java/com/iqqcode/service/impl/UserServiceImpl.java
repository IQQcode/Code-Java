package com.iqqcode.service.impl;

import com.iqqcode.dao.UserDao;
import com.iqqcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <bean id="userService" class="com.iqqcode.service.impl.UserServiceImpl/">
 */
//@Component("userService")
@Scope("singleton")
@Service("userService")
public class UserServiceImpl implements UserService {
    //属性注入
    @Value("${jdbc.driver}") //去spring容器中寻找匹配的key,将value对应的赋给属性
    private String driver;


    //对象自动注入
    //<property name="userDao" ref="userDao"/>

    //@Autowired  //按照数据类型从Spring容器中进行匹配(如果有多个相同类型则不能匹配，结合@Qualifier)
    //@Qualifier("userDao")  //按照id值从容器中进行匹配，必须结合Autowired一起使用
    @Resource(name = "userDao")  //相当于@Autowired + @Qualifier
    private UserDao userDao;

    public UserServiceImpl() { }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void login() {
        System.out.println(driver);
        userDao.login();
    }
}
