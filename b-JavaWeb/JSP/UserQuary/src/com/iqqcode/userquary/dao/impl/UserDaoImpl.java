package com.iqqcode.userquary.dao.impl;


import com.iqqcode.userquary.dao.UserDao;
import com.iqqcode.userquary.domain.User;
import com.iqqcode.userquary.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 12:10
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 使用JDBC操纵数据库
     * @return
     */
    @Override
    public List<User> findAll() {
        //定义SQL
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
