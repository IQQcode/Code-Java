package com.iqqocde.druid;

import com.iqqcode.utils.DruidUtils;
import com.iqqcode.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 21:52
 * @Description:
 */
public class DruidUtilsTest {
    @Test
    public void testDruidSource() {
        Connection coon = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            coon = DruidUtils.getConnection();
            String sql = "select * from user where username like ?";
            ps = coon.prepareStatement(sql);
            ps.setString(1,"%佩%");
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                //每一行记录认为是一个对象
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String age = resultSet.getString("age");
                String sex = resultSet.getString("sex");
                System.out.println("----------------------------------");
                System.out.println("id : "+id+" \nusername : "+username +"\npassword : "+password +"\nage : "+age+"\nsex : "+sex);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResources(coon,ps,resultSet);
        }
    }
}
