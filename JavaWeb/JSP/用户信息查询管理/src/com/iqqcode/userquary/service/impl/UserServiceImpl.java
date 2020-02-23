package com.iqqcode.userquary.service.impl;

import com.iqqcode.userquary.dao.UserDao;
import com.iqqcode.userquary.dao.impl.UserDaoImpl;
import com.iqqcode.userquary.domain.User;
import com.iqqcode.userquary.service.UserService;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 12:05
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    /**
     * 调用dao完成查询
     * @return
     */
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void delSelectedUser(String[] ids) {

    }
}
