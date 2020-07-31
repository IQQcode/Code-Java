package com.iqqcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-30 17:19
 * @Description:
 */

@RestController
public class HelloController {
    @Autowired
    private DataSource dataSource;


    @GetMapping("hello")
    public String hello() {
        System.out.println("DataSource = " + dataSource);
        return "Hello SpringBoot!";
    }
}
