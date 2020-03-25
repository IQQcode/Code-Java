package com.iqqcode.travelocity.dao;


import com.iqqcode.travelocity.domain.User;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-24 11:33
 * @Description:
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    void save(User user);

    /**
     * 根据激活码查询用户对象
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 修改指定用户激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
