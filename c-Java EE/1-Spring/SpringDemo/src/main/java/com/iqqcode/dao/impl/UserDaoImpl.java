package com.iqqcode.dao.impl;

import com.iqqcode.dao.UserDao;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-28 00:37
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("user save!");
    }
}
