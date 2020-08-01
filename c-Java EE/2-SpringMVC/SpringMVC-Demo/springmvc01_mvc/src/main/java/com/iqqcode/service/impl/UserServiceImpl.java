package com.iqqcode.service.impl;

import com.iqqcode.dao.UserDao;
import com.iqqcode.dao.impl.UserDaoImpl;
import com.iqqcode.service.UserService;
import lombok.Data;

@Data
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void login() {
        userDao.login();
    }


}
