package com.iqqcode.travelocity.dao.impl;


import com.iqqcode.travelocity.dao.RouteDao;
import com.iqqcode.travelocity.domain.Route;
import com.iqqcode.travelocity.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-27 14:34
 * @Description:搜索功能--多条件组合查询
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
        //String sql = "select count(*) from tab_route where cid = ?";
        //1.定义SQL模板
        String sql = "select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //多条件存放
        List params = new ArrayList();
        //2.判断参数是否又值
        if(cid != 0) {
            sb.append( " and cid = ? ");
            params.add(cid);//添加sql中 ？对应的值
        }
        if(rname != null && rname.length() > 0 && !"null".equals(rname)) {
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sql = sb.toString(); //将参数拼接到sql中

        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        //开始查询位置，查询条目数
        //"select * from tab_route where cid = ? and rname like ?  limit ? , ?";

        //1.定义SQL模板
        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();

        //2.判断参数是否又值
        if(cid != 0) {
            sb.append( " and cid = ? ");
            params.add(cid);
        }
        if(rname != null && rname.length() > 0 && !"null".equals(rname)) {
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ? , ? ");//分页条件
        sql = sb.toString();

        params.add(start);
        params.add(pageSize);

        return template.query(sql , new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findRouteDetails(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}
