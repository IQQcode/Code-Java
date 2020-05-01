package org.iqqcode.service.impl;

import org.iqqcode.dao.UserDao;
import org.iqqcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:用户的业务逻辑层接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void regist() {
        userDao.regist();
    }
}
