package org.iqqcode.domain;


import lombok.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-03 18:03
 * @Description:
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String qq;
    private String username;
    private String password;
}
