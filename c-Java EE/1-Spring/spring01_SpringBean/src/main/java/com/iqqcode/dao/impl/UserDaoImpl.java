package com.iqqcode.dao.impl;

import com.iqqcode.dao.UserDao;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-29 23:43
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("user save!");
    }
}
