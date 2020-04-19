package org.iqqcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iqqcode.domain.Account;

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
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
