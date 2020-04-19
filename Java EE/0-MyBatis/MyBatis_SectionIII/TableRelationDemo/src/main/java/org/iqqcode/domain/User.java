package org.iqqcode.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:42
 * @Description:用户实体类---与账户一对多
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    //一对多关系映射: 主表实体应该包含从表实体的集合引用
    //主表为user,从表为account
    private List<Account> accounts;
}
