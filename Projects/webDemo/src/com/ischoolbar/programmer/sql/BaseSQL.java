package com.ischoolbar.programmer.sql;

import com.ischoolbar.programmer.util.DataBaseUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装对数据库的基本操作
 */
public class BaseSQL {
    private DataBaseUtil dbUtil = new DataBaseUtil();

    /**
     * 及时的关闭数据库链接,释放资源
     */
    public void closeCon() {
        dbUtil.closeCon();
    }

    /**
     * 多条基础查询
     *
     * 表示一个数据库查询的结果集，一个ResultSet对象具有一个游标指向当前行的结果集
     */

    public ResultSet query(String sql) {
        try {

            //与数据库连接之后，获取数据库的对象，传入sql，对传入的对象进行操作
            PreparedStatement preparedStatement = dbUtil.getConnection().prepareStatement(sql);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
