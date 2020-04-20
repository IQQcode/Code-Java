package org.iqqcode.dao;

import org.iqqcode.domain.Account;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-19 15:31
 * @Description:账户与用户一对一
 */
public interface IAccountDao {
    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<Account> findAccountUser();
}
