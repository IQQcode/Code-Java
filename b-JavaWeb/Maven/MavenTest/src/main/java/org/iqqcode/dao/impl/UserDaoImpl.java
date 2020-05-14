package org.iqqcode.dao.impl;
import java.sql.*;


import org.iqqcode.dao.UserDao;
import org.iqqcode.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-03 18:15
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() throws SQLException {
        List<User> list = new ArrayList<User>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet result = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db_userquary","root", "1234");
            ps = connection.prepareStatement("select * from user");
            result = ps.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setGender(result.getString("gender"));
                user.setAge(result.getInt("age"));
                user.setAddress(result.getString("address"));
                user.setQq(result.getString("qq"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                list.add(user);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
            ps.close();
            result.close();
        }
        return null;
    }
}
