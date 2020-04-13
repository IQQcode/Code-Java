package org.iqqcode.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-08 12:04
 * @Description:用户实体类
 */

/**实现Serializable接口，将对象序列化*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private String address;
}
