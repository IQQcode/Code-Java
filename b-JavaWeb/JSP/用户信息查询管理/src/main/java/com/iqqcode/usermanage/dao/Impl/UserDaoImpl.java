package com.iqqcode.usermanage.dao.impl;

import com.iqqcode.usermanage.dao.UserDao;
import com.iqqcode.usermanage.domain.User;
import com.iqqcode.usermanage.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 12:10
 * @Description:数据访问层，SQL语句操纵数据库
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 使用JDBC操纵数据库
     * @return
     */
    @Override
    public List<User> findAll() {
        //定义SQL
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username, password);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        //定义SQL
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //执行SQL
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        //定义SQL
        String sql = "delete from user where id = ?";
        //执行SQL
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        //定义SQL
        String sql = "select *  from user where id = ?";
        //执行SQL
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        //执行SQL
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    /**
     * 分页复杂条件查询
     * @param condition
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板化SQL
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(!"".equals(value) && value != null) {
                //有值,拼接SQL
                sb.append(" and " + key + " like ? ");
                // ?条件的值
                params.add("%" + value + "%");
            }
        }
        System.out.println(sql);
        System.out.println(params);
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    /**
     * 分页数据显示
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(!"".equals(value) && value != null) {
                //有值,拼接SQL
                sb.append(" and " + key + " like ? ");
                // ?条件的值
                params.add("%" + value + "%");
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
