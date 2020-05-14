package org.iqqcode.web;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-27 11:28
 * @Description:
 */

class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

public class Test {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        user1.setUsername("zhangsan");
        user2 = user1;
        System.out.println(user1);
        System.out.println(user2);
        user2.setUsername("lisi");
        System.out.println(user1.getUsername());
        System.out.println(user2.getUsername());
    }
}
