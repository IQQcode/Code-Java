package jdbc.control;

import	java.sql.DriverManager;
import org.junit.Test;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-06 17:08
 * @Description:
 */
public class JDBCDemoUpdate {
    @Test
    public void testUpdate() {
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql:///jdbc","root","1234");
            // 3.执行SQL
            String sql = "update user set password = 123456 where id = 3";
            Statement statement = connection.createStatement();
            // 返回结果
            int result = statement.executeUpdate(sql);
            System.out.println("受影响行数： " + result);
            //4.释放资源
            connection.close();
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
