package com.iqqcode.factory;

import com.iqqcode.dao.UserDao;
import com.iqqcode.dao.impl.UserDaoImpl;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-27 23:01
 * @Description:工厂实例方法实例化Bean
 */
public class InstanceFactory {
    public UserDao getInstanceFactory() {
        return new UserDaoImpl();
    }
}