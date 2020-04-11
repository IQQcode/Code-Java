package org.iqqcode.domain;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 09:42
 * @Description:
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**实现Serializable接口，将对象序列化*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
