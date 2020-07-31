package com.iqqcode.service;

import com.iqqcode.domain.User;
import com.iqqcode.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户查询
     * @param id
     * @return
     */
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }


    /**
     * 保存用户
     * @param user
     */
    @Transactional   //多事务，要操纵多个数据库；一个失败之后回滚
    public void save(User user) {
        System.out.println("新增用户...");
        //选择性新增: 如果属性为空则该属性不会出现在insert语句上
        userMapper.insertSelective(user);
        //int i = 1 / 0;
    }
}
