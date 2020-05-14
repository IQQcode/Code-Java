package org.iqqcode.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-21 16:34
 * @Description:用户实体类
 */
@Data
public class User implements Serializable {
    //实体类属性与数据库表字段不对应
    private Integer userId;
    private String userName;
    private String userAddress;
    private String userSex;
    private Date userBirthday;

    //一对多关系映射：一个用户对应多个账户
    private List<Account> accounts;
}

