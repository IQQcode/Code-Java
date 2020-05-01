package org.iqqcode.dao;


import org.iqqcode.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:56
 * @Description:用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询用户信息
     */
    List<User> findAll();
    /**
     * 查询一个
     * @return
     */
    User findUserById(int uid);

    /**
     * 保存
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除
     * @param uid
     */
    void deleteUser(int uid);
}
