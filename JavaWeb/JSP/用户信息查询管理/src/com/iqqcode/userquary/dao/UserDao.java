package com.iqqcode.userquary.dao;


import com.iqqcode.userquary.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 12:09
 * @Description:用户操作的dao
 */
public interface UserDao {
    List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findById(int i);

    void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
