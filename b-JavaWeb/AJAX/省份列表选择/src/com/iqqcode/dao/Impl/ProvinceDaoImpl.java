package com.iqqcode.dao.Impl;


import com.iqqcode.dao.ProvinceDao;
import com.iqqcode.domain.Province;
import com.iqqcode.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-17 13:46
 * @Description:JdbcTemplate
 */
public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量 JdbcTemplate
    private JdbcTemplate tp = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //定义SQL
        String sql = "select * from province";
        //执行SQL
        List<Province> list = tp.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
