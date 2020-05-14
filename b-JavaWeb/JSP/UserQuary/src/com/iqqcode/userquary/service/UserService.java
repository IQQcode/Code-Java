package com.iqqcode.userquary.service;


import com.iqqcode.userquary.domain.User;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 11:59
 * @Description:用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
}
