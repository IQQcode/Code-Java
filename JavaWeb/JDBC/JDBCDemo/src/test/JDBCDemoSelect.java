import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-30 20:12
 * @Description: 会存在 SQL注入的隐患
 */

public class JDBCDemoSelect {
    @Test
    public void testSelect(){
        try {
            //1.加载驱动
            Class forName = Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","1234");

            //3.执行SQl

            String sql = "select * from user";
            Statement statement = connection.createStatement();
            statement.execute(sql);
             //查询的结果通过 ResultSet 放入到结果集中
            ResultSet resultSet = statement.executeQuery(sql);


            //遍历结果集
            while (resultSet.next()) {
                //每一行记录认为是一个对象
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id : "+id+" \nusername : "+username +"\npassword : "+password);
            }

            //4.释放资源
            connection.close();
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
