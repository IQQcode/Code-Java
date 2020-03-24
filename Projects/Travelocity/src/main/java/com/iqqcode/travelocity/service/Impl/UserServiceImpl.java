package com.iqqcode.travelocity.service.impl;


import com.iqqcode.travelocity.dao.UserDao;
import com.iqqcode.travelocity.dao.impl.UserDaoImpl;
import com.iqqcode.travelocity.domain.User;
import com.iqqcode.travelocity.service.UserService;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-24 11:36
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        userDao.save(user);

        return true;
    }
}
