package org.iqqcode.dao;

import org.iqqcode.domain.User;

import java.util.List;


public interface IUserDao {
    /**
     * 根据用户id查询账户列表信息
     * 
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户列表信息
     * 
     * @param userId
     * @return
     */
    User findById(int userId);
}