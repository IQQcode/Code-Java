package com.iqqcode.bean;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 08:31
 * @Description:
 */

public class UserInfo {
    private String username;

    public UserInfo() { }

    public UserInfo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    /**
     * DI
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String helloWorld() {
        return "Hello Spring! " + username;
    }
}
