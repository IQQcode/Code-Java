package com.iqqcode.userquary.service;


import com.iqqcode.userquary.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 11:59
 * @Description:用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 保存User
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除User
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);
}
