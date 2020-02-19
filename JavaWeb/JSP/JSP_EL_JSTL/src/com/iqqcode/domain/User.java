package com.iqqcode.domain;


import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-19 21:29
 * @Description:
 */
public class User {
    private String name;
    private int age;
    private Date birthday;

    /**
     * 逻辑视图:在页面上按需求输出数据
     * @return
     */
    public String getBirStr() {
        if(birthday != null) {
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDate.format(birthday);
        }else {
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int ade) {
        this.age = ade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ade=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
