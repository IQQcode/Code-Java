package com.iqqcode.json.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-16 15:27
 * @Description:
 */
public class Person {
    private String name;
    private int age;
    private String address;

    //@JsonIgnore //忽略该属性
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
