package com.ischoolbar.programmer.sql;

import com.ischoolbar.programmer.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理员数据库封装
 */

public class AdminSQL extends BaseSQL {
    public Admin login(String name,String password) {
        String sql = "select * from sm_admin where name = '" + name + "' and password = '" + password;
        // qury()多条基础查询
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
                admin.setPassword(resultSet.getString(password));
                admin.setStatus(resultSet.getInt("status"));
                return admin;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
