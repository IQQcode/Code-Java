package org.iqqcode.dao;

import org.iqqcode.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:41
 * @Description:用户与账户一对多
 */
public interface IUserDao {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();
}
