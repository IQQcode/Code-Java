package com.Annotations;

public class Person {

    @Name(value = "Mr.Q")
    public String name;
    public String age;

    @Sex(gender = Sex.GenderType.Male)
    public String sex;

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}