package org.iqqcode.dao;


import org.iqqcode.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-03 18:13
 * @Description:
 */
public interface UserDao {
    List<User> findAll() throws SQLException;
}
