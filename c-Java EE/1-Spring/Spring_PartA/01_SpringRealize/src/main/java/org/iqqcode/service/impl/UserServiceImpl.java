package org.iqqcode.service.impl;

import org.iqqcode.dao.UserDao;
import org.iqqcode.service.UserService;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:用户的业务逻辑层接口实现类
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        System.err.println("对象创建了！");
    }

    public void regist() {
        userDao.regist();
    }
}
