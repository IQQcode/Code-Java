package com.iqqcode.dao.impl;

import com.iqqcode.dao.AccountDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Data
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?",money,outMan);
    }

    @Override
    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?",money,inMan);
    }
}
