package org.iqqcode.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import	java.sql.PreparedStatement;
import	java.sql.Connection;
import java.sql.SQLException;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 09:50
 * @Description:
 */
public class JDBCUtilsPreparedStatementTest {
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into user(username,password) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Tom");
            statement.setString(2, DigestUtils.md5Hex("1234"));
            int effect = statement.executeUpdate();
            // 如果 effect == 1则插入成功(受影响的行数)
            Assert.assertEquals(1,effect);

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResources(connection,statement);
        }
    }
}
