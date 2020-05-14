package com.iqqcode.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 18:57
 * @Description:实体类
 */
@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String passwrd;
    private int age;
    private String sex;
}
