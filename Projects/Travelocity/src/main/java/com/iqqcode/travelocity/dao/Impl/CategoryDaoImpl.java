package com.iqqcode.travelocity.dao.impl;


import com.iqqcode.travelocity.dao.CategoryDao;
import com.iqqcode.travelocity.domain.Category;
import com.iqqcode.travelocity.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-26 15:54
 * @Description:
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findSort() {
        String sql = "select * from tab_category";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}
