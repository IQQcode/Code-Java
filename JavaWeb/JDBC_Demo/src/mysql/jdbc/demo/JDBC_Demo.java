package mysql.jdbc.demo;

import	java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Objects;

public class JDBC_Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        try (
                //建立数据库连接
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memo?user=root&password=1234&useUnicode=true&characterEncoding=UTF-8");

                //创建操作命令
                Statement statement = connection.createStatement();

                //执行SQL语句  (resultSet为返回结果,executeQuery执行SQL语句)
                ResultSet resultSet = statement.executeQuery("select id,group_id,title,content,is_protected,background,is_remind,remind_time,created_time,modify_time from memo_info");

        ) {

            //处理返回结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Date createTime = resultSet.getDate("created_time");
                System.out.println(String.format("Memo: id = %d,title = %s,content = %s,createTime=%s",
                        id,title,content,createTime.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
