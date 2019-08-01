package jdbc.control;

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

            String userName = "zs";
            String password = "1234";
            String sql = "select * from user" + " where username = ? and password = ?";

            //预编译SQl
            PreparedStatement statement = connection.prepareStatement(sql);
            // 1表示对应第一个占位符
            statement.setString(1,userName);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                System.out.println("Login Success!");
            }else {
                System.out.println("Login Failure...");
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
