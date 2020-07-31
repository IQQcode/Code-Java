package com.iqqcode.controller;

import com.iqqcode.domain.User;
import com.iqqcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-30 17:19
 * @Description:
 */

@RestController
public class Controller {
    @Autowired
    private DataSource dataSource;

    @Value("${iqqcode.url}")
    private String iqqcodeUrl;

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/user/{id}")
    public User queryUser(@PathVariable Long id) {
        return userService.queryById(id);
    }

    @GetMapping("hello")
    public String hello() {
        System.out.println("iqqcode = " + iqqcodeUrl);
        System.out.println("DataSource = " + dataSource);
        return "Hello SpringBoot!";
    }
}
