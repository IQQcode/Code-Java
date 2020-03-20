package com.iqqcode.usermanage.domain;


import lombok.Data;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 11:47
 * @Description:JavaBean User实体类
 */
@Data
public class User {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String qq;
    private String email;
    private String username;
    private String password;
}
