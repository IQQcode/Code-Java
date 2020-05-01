package org.iqqcode.service.impl;

import lombok.Data;
import org.iqqcode.dao.UserDao;
import org.iqqcode.domain.User;
import org.iqqcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:用户的业务逻辑层接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findUserById(int uid) {
        return userDao.findUserById(uid);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(int uid) {
        userDao.deleteUser(uid);
    }
}
