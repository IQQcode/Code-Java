package jdbc.injection;


import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-07 11:57
 * @Description:Statement执行SQL会产生SQL注入
 */
public class SQLInjection02 {
    @Test
    public void test3() {
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                    "root","1234");
            // 3.执行SQL
            String userName = "zs'or 1 = 1";
            String password = "fdfdfdfdf";
            String sql = "select * from user where username = '"+userName+" " +
                    "and password = '"+password+"' ";

            //知道用户名可以直接登录
            // 通过 or 拆分SQL语句,一条语句变为两条,password不在验证
            // select * from user where username = 'zs' or 1 = 1 and password = 'fdfdfdfdf';

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // 遍历结果集
            if (resultSet.next()) {
                System.out.println("登录成功！");
            }else {
                System.out.println("登录失败！");
            }
            // 4.释放资源
            connection.close();
            statement.close();
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
