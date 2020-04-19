package org.iqqcode.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:42
 * @Description:账户实体类---与用户一对一(多对一)
 */

/**实现Serializable接口，将对象序列化*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private int id;
    private int uid;
    private double money;

    //一对一关系映射: 从表实体应该包含一个主表实体的对象引用
    //主表为user,从表为account
    private User user;
}
