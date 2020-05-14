package org.iqqcode.dao.impl;
import java.sql.SQLException;
import	java.util.List;


import org.iqqcode.dao.UserDao;
import org.iqqcode.domain.User;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-03 18:38
 * @Description:
 */
public class UserDaoImplTest {
    @Test
    public void testFindAll() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user.getName());
        }
    }
}
