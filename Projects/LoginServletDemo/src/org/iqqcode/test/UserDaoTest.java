package org.iqqcode.test;


import org.iqqcode.dao.UserDao;
import org.iqqcode.domain.User;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-09 11:34
 * @Description:
 */
public class UserDaoTest {
    @Test
    public void testLogin() {
        User useLogin = new User();
        useLogin.setUsername("admin");
        useLogin.setPassword("admin");

        UserDao dao = new UserDao();
        User user = dao.login(useLogin);

        System.out.println(user);
    }
}
