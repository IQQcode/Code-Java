package com.iqqcode.factory;

import com.iqqcode.dao.UserDao;
import com.iqqcode.dao.impl.UserDaoImpl;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-27 22:48
 * @Description:工厂静态方法实例化Bean
 */
public class StaticFactory {
    public static UserDao getStaticFactory() {
        return new UserDaoImpl();
    }
}

