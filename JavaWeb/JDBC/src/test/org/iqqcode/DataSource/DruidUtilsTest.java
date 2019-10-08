package org.iqqcode.DataSource;

import org.iqqcode.utils.JDBCUtils;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 10:43
 * @Description:
 */
public class DruidUtilsTest {
    @Test
    public void TestSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //获取连接
            connection = DruidUtils.getConnection();
            String sql = "SELECT * FROM user WHERE  username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"Sunny");
            resultSet = preparedStatement.executeQuery();

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
            JDBCUtils.closeResources(connection,preparedStatement,resultSet);
        }
    }

}