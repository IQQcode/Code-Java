package com.sql.storage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-08 14:50
 * @Description:实现图片（本地、数据库互相传输）
 */
public class ImageDemo {

    /**
     * @addImageToDB 将图片插入数据库
     */

    public static void addImageToDB() {
        String path = "D:/1.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConn();
            String sql = "insert into photo (name,photo) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Tom2");
            ps.setBinaryStream(2, in, in.available());
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * @readDBToImage() 读取数据库中图片
     */
    public static void readDBToImage() {
        //String targetPath = "D:/1.jpg";
        String targetPath_base = "D:/1.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int numOfPicture = 2;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from photo where id =?";
            ps = conn.prepareStatement(sql);
            for(int i = 1; i <= numOfPicture; i++) {
                ps.setInt(1, i);
                rs = ps.executeQuery();

                String name = null;

                while (rs.next()) {
                    name = rs.getString(2);
                    InputStream in = rs.getBinaryStream("photo");
                    ImageUtil.readBin2Image(in, targetPath_base+name+".jpg");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //测试
    public static void main(String[] args) {
        //addImageToDB();
        readDBToImage();
    }
}
