package org.iqqcode.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-21 16:34
 * @Description:用户实体类
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    //多对一（mybatis中称之为一对一）的映射：一个账户只能属于一个用户
    private User user;
}
