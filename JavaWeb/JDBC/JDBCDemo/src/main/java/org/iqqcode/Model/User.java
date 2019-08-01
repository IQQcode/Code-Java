package org.iqqcode.Model;


import org.junit.experimental.theories.DataPoint;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 11:44
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
