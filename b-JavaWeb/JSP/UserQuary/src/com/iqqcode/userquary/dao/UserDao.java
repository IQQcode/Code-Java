package com.iqqcode.userquary.dao;


import com.iqqcode.userquary.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 12:09
 * @Description:用户操作的dao
 */
public interface UserDao {
    public List<User> findAll();
}
