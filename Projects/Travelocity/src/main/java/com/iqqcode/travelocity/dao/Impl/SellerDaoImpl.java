package com.iqqcode.travelocity.dao.impl;


import com.iqqcode.travelocity.dao.SellerDao;
import com.iqqcode.travelocity.domain.RouteImg;
import com.iqqcode.travelocity.domain.Seller;
import com.iqqcode.travelocity.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-28 18:57
 * @Description:
 */
public class SellerDaoImpl implements SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findById(int id) {
        String sql = "select * from tab_seller where sid = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class), id);
    }
}
