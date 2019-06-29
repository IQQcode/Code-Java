package com.ischoolbar.programmer.model;

/**
 *  管理员实体类
 */
public class Admin {
    private int id;          //定义用户id
    private String name;     //定义用户名
    private String password; //定义用户密码
    private int status = 1;   //用户状态,"1"表示登录


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) { this.status = status;
    }

}
