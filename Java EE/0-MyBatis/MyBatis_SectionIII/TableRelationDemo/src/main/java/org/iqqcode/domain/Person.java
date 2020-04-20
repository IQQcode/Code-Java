package org.iqqcode.domain;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-19 22:41
 * @Description:Person实体类---与Role多对多
 * 一个用户可以有多个角色
 * 一个角色可以赋予多个用户
 */
@Data
public class Person implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    //多对多的关系映射：一个用户可以具备多个角色
    //user表，role表，person_role表为连接两表
    private List<Role> roles;
}
