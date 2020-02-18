package org.iqqcode.dao;


import org.iqqcode.domain.User;
import org.iqqcode.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-09 10:27
 * @Description:操纵数据库中User类的表
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate  template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名,密码
     * @return user 包含用户全部数据
     */
    public User login(User loginUser) {
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用quary方法
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
