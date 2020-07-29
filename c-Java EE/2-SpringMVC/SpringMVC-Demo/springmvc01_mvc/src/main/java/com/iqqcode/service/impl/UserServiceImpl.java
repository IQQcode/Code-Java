package com.iqqcode.service.impl;

import com.iqqcode.dao.UserDao;
import com.iqqcode.service.UserService;
import lombok.Data;

@Data
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public void login() {
        userDao.login();
    }
}
