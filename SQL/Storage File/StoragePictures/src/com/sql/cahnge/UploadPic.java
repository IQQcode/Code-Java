package com.sql.cahnge;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-08 15:05
 * @Description:
 */
public class UploadPic {
    private static final String  URL="jdbc:mysql://localhost:3306/test";
    private static final String USER="root";
    private static final String PASS="1234";
    public static void main(String[] args) throws SQLException, IOException {
        try {
            Class forName = Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(URL,USER,PASS);
            InputStream in=ImageUtil.getImageByte("D://1.jpg");
            String sql="insert into tb_file(fname,fcontent) values(?,?)";
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,"凡凡");
            ptmt.setBinaryStream(2, in,
                    in.available());
            ptmt.execute();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

