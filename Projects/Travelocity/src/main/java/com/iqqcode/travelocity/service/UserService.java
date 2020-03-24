package com.iqqcode.travelocity.service;


import com.iqqcode.travelocity.domain.User;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-24 11:36
 * @Description:
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);
}
