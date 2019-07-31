import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-31 16:26
 * @Description:
 */
public class JDBCDemoSelectPlus {
    @Test
    public void testSelectPlus(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","1234");

            //3.执行SQl

            String sql = "select * from user where username = ? and password = ?";
            //预编译SQl
            PreparedStatement statement = connection.prepareStatement(sql);
            String userName = "ls";
            String password = "1234";
            statement.setString(1,userName);
            statement.setString(2,userName);
            ResultSet resultSet = statement.executeQuery();

            //遍历结果集
            while (resultSet.next()) {
                //每一行记录认为是一个对象
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
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
