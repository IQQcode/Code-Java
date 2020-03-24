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
}
