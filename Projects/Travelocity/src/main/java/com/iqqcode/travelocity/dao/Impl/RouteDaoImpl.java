package com.iqqcode.travelocity.dao.impl;


import com.iqqcode.travelocity.dao.RouteDao;
import com.iqqcode.travelocity.domain.Route;
import com.iqqcode.travelocity.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-27 14:34
 * @Description:
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid) {
        String sql = "select count(*) from tab_route where cid = ?";
        return template.queryForObject(sql, Integer.class, cid);
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {
        //开始查询位置，查询条目数
        String sql = "select * from tab_route where cid = ? limit ? , ?";
        return template.query(sql , new BeanPropertyRowMapper<Route>(Route.class), cid, start, pageSize);
    }
}
