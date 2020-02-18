package org.iqqcode.domain;


/**
 * @Author: Mr.Q
 * @Date: 2020-02-09 09:05
 * @Description:用户实体类
 */
public class User {
    private int id;
    private String username;
    private String password;
    //private String verification;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
