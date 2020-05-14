package com.chartroom.dao;

import com.chartroom.entity.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-10 09:56
 * @Description:
 */

public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();

    @Test
    public void userLogin() {
        User user = accountDao.userLogin("test","123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void userRegister() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123");
        boolean isSuccess = accountDao.userRegister(user);
        Assert.assertEquals(true, isSuccess);
    }
}
