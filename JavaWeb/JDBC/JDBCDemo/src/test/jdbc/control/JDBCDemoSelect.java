package jdbc.control;

import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-30 20:12
 * @Description: 会存在 SQL注入的隐患
 */

public class JDBCDemoSelect {
    @Test
    public void testSelect() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class forName = Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","1234");

            //3.执行SQl

            String sql = "select * from user";
            statement = connection.createStatement();

            //查询的结果通过 ResultSet 放入到结果集中
            resultSet = statement.executeQuery(sql);

            //遍历结果集
            while (resultSet.next()) {
                //每一行记录认为是一个对象
                int id = resultSet.getInt(1);
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id : "+id+" \nusername : "+username +"\npassword : "+password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源

            //避免空指针异常
            if(statement != null) {
                //statement != null则获取到到了资源;statement = null则为空,未获取到
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
