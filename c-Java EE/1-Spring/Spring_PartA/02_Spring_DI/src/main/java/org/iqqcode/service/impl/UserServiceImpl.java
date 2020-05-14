package org.iqqcode.service.impl;

import org.iqqcode.service.UserService;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 10:58
 * @Description:DI--构造函数注入
 */
public class UserServiceImpl implements UserService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;  //基本类型
    private Integer age;  //包装类型
    private Date date;  //其他包装类

    public UserServiceImpl(String name, Integer age, Date date) {
        System.err.println("对象创建了！");
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public void regist() {
        System.err.println("\nregist()执行了...");
        System.out.print("\n-----------------------\nname: "+name+"\nage: "+age+"\ndate: "+date);
    }
}
