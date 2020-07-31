package com.iqqcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Value(("${java.url}"))
    private String javaUrl;

    @GetMapping("hello")
    public String hello() {
        System.out.println("iqqcode = " + iqqcodeUrl);
        System.out.println("java = " + javaUrl);
        System.out.println("DataSource = " + dataSource);
        return "Hello SpringBoot!";
    }
}
