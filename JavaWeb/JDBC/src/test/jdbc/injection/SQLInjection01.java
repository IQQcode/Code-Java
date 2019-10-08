package jdbc.injection;


import org.junit.Test;

import java.sql.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-07 11:53
 * @Description:Statement执行SQL会产生SQL注入
 */
public class SQLInjection01 {
    @Test
    public void test3() {
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                    "root","1234");
            // 3.执行SQL
            String userName = "zs' --";
            String password = "fdfdfdfdf";
            String sql = "select * from user where username = '"+userName+" " +
                    "and password = '"+password+"' ";

            //知道用户名可以直接登录
            // 通过 -- 注释 SQL语句,password被注释
            // select * from user where username = 'zs' -- and password = 'fdfdfdfdf';

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

