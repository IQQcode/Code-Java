package com.iqqcode.service.impl;

import com.iqqcode.dao.AccountDao;
import com.iqqcode.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        //事务控制 out() 和 in()方法同时成功，同时失败
        int i = 1/0; //自杀式错误
        accountDao.in(inMan,money);
    }
}
