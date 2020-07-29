package com.iqqcode.service.impl;

import com.iqqcode.dao.AccountDao;
import com.iqqcode.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);

        //事务控制 out() 和 in()方法同时成功，同时失败
        int i = 1/0; //自杀式错误

        accountDao.in(inMan, money);
    }
}
