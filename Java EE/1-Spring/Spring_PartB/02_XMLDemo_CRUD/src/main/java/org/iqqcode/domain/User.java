package org.iqqcode.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-30 09:24
 * @Description:用户实体类
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
}
