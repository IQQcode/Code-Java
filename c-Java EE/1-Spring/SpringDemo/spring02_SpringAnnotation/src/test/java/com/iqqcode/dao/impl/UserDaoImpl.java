package com.iqqcode.dao.impl;

import com.iqqcode.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/*<bean id="userDao" class="com.iqqcode.dao.impl.UserDaoImpl"/>*/
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void login() {
        System.out.println("user login loading...");
    }
}
