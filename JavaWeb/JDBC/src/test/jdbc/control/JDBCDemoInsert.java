package jdbc.control;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-30 20:56
 * @Description:
 */
public class JDBCDemoInsert {
    @Test
    public void testInsert(){
        try {
            //1.加载驱动
            Class forName = Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","1234");

            //3.执行SQl
            String sql = "insert into user(username, password) values ('Tom','123')";
            Statement statement = connection.createStatement();
            int resultRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);

            System.out.println(resultRows);


            //4.释放资源
            connection.close();
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
