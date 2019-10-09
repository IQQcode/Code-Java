package com.sql.storage;
import	java.sql.ResultSet;
import	java.sql.PreparedStatement;
import	java.sql.DriverManager;
import	java.sql.Connection;
import java.sql.SQLException;


/**
 * @Author: Mr.Q
 * @Date: 2019-10-09 19:46
 * @Description:数据库操作类
 */
public class DBUtil {
    // 定义数据库连接参数
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";


    /**
     * 连接数据库
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (conn != null) {
                System.out.println("成功连接到数据库！");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("数据库连接失败...");
        }
        return conn;
    }

    /**
     * 插入数据
     * @param FltNum
     * @param FltLine
     * @param FltDate
     * @param PsgName
     * @param PsgType
     * @param PsgSex
     * @param PsgCab
     * @param PsgSeatNo
     * @param PsgInfo
     * @return
     * @throws SQLException
     */
    public boolean insertText(String FltNum, String FltLine, String FltDate,
                              String PsgName, String PsgType, String PsgSex,
                              String PsgCab, String PsgSeatNo, String PsgInfo) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "insert into text_pictureinformation values('" + FltNum + "','"
                + FltLine + "','" + FltDate + "','" + PsgName + "','" + PsgType
                + "','" + PsgSex + "','" + PsgCab + "','" + PsgSeatNo + "','"
                + PsgInfo + "')";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            int count = pstmt.executeUpdate();
            if(count > 0) {
                flag = true;
                System.out.println("插入数据成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("插入数据失败...");
        } finally {
            conn.close();
            pstmt.close();
        }
        return flag;
    }

    public void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
