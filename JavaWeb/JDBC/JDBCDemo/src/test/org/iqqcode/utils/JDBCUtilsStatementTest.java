package org.iqqcode.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.Assert.*;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 09:21
 * @Description:
 */
public class JDBCUtilsStatementTest {
    @Test
    public void Test() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            String sql = "select * from user";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                System.out.println("id : "+id+" \tusername : "+userName +"\tpassword : "+password);
            }
        }catch (SQLException e){
            System.err.println("数据库异常...");
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResources(connection,statement,resultSet);
        }
    }

}
