package com.iqqcode.test;

import com.iqqcode.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test_add() {
        int add = jdbcTemplate.update("insert into account values (?, ?)", "王五", 1000);
        System.out.println(add);
    }

    @Test
    public void test_delete() {
        int delete = jdbcTemplate.update("delete from account where name = ?", "王五");
        System.out.println(delete);
    }

    @Test
    public void test_update() {
        int update = jdbcTemplate.update("update account set money=? where name=?", 100000, "Tom");
        System.out.println(update);
    }




    //查询总记录
    @Test
    public void test_queryAll() {
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(list);
    }

    //查询单条记录
    @Test
    public void test_queryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), "Tom");
        System.out.println(account);
    }

    //查询总数
    @Test
    public void test_queryCount() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
        System.out.println(count);
    }
}
