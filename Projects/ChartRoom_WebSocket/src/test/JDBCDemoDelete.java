import org.junit.Test;

import	java.sql.ResultSet;
import	java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-30 21:09
 * @Description:
 */
public class JDBCDemoDelete {
    @Test
    public void testDelete(){
        try {
            //1.加载驱动
            Class forName = Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","1234");

            //3.执行SQl
            String sql = "delete from  user where username = 'Tom'";
            Statement statement = connection.createStatement();
            int resultRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);

            System.out.println("受影响行数： " + resultRows);

            //4.释放资源
            connection.close();
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
