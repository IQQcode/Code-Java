package com.iqqcode.travelocity.dao.impl;


import com.iqqcode.travelocity.dao.RouteImgDao;
import com.iqqcode.travelocity.domain.RouteImg;
import com.iqqcode.travelocity.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-28 18:46
 * @Description:
 */
public class RouteImgDaoImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ? ";
        return template.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }
}
