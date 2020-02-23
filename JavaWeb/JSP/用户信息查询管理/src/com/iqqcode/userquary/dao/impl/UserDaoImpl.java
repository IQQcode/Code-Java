package com.iqqcode.userquary.dao.impl;


import com.iqqcode.userquary.dao.UserDao;
import com.iqqcode.userquary.domain.User;
import com.iqqcode.userquary.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

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

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username, password);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findById(int i) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        return 0;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        return null;
    }


}
