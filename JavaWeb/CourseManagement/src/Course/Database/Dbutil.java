package Course.Database;

import java.sql.*;

/**
 * 封装数据库的基本操作
 */

public class Dbutil {

    //数据库驱动
    private String driver="com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_course_management?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "1234";
    //数据库的连接对象
    private static Connection conn = null;
    //Statement对象
    private static  PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 连接数据库
     * @return
     * @throws SQLException
     */

    public   Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
            //连接数据库
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            System.err.println("无法连接数据库！");
        }//加载驱动
        return conn;
    }

    //执行sql语句，可以进行查询
    /**
     * statement 用于执行静态SQL语句并返回其生成的结果的对象
     *
     * @executeQuery(String sql)
     * 这个方法被用来执行 SELECT 语句，但也只能执行查询语句，
     * 执行后返回代表查询结果的ResultSet对象
     *
     * @param preparedSql
     * @param param
     * @return
     */
    public ResultSet executeQuery(String preparedSql,String []param){
        try {
            ps = conn.prepareStatement(preparedSql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;

    }

    //执行sql语句，增加，修改，删除

    /**
     * @executeUpdate
     * 用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL(数据定义操纵)语句
     * INSERT、UPDATE 或 DELETE 语句的效果是修改表中零行或多行中的一列或多列
     * executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）
     *
     * @param preparedSql
     * @param param
     * @return
     */
    public int executeUpdate(String preparedSql,String[]param){
        int num = 0;
        try {
            ps = conn.prepareStatement(preparedSql);
            if(ps != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            num = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return num;
    }

    public static void main(String[] args) {
        try {
            Dbutil dao = new Dbutil();
            Connection conn = dao.getConnection();
            if(conn != null) {
                System.out.println("连接数据库正常");
            } else {
                System.out.println("连接数据库异常");
            }
        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
        }
    }
}
