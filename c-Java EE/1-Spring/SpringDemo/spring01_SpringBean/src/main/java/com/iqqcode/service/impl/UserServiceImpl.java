package com.iqqcode.service.impl;

import com.iqqcode.dao.UserDao;
import com.iqqcode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 00:39
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() { }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        userDao.save();
    }
}
