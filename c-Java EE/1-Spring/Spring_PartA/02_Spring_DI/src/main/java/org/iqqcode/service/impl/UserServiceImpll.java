package org.iqqcode.service.impl;

import org.iqqcode.service.UserService;

import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:DI--Setter()注入
 */
public class UserServiceImpll implements UserService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;  //基本类型
    private Integer age;  //包装类型
    private Date date;  //其他包装类

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void regist() {
        System.err.println("regist()执行了...");
        System.out.print("\n-----------------------\nname: "+name+"\nage: "+age+"\ndate: "+date);
    }
}
