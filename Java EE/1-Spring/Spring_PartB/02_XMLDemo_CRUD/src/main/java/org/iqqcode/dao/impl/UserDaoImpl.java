package org.iqqcode.dao.impl;

import lombok.Data;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.iqqcode.dao.UserDao;
import org.iqqcode.domain.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:用户的持久层接口实现类
 */
@Data
public class UserDaoImpl implements UserDao {

    private QueryRunner run;

    public List<User> findAll() {
        try {
            return run.query("select * from spring_user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findUserById(int uid) {
        try {
            return run.query("select * from spring_user where id = ?", new BeanHandler<User>(User.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(User user) {
        try {
            run.update("insert into spring_user(name,age) values(?, ?)", user.getName(), user.getAge());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        try {
            run.update("update spring_user set name = ?,age = ? where id = ?", user.getName(), user.getAge(), user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int uid) {
        try {
            run.update("delete from spring_user where id = ?", uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
