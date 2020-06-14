package com.iqqcode.reflect01;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 16:14
 * @Description:POJO实体类
 */
public class Person {

    private String name;
    private int age;

    public Person() { }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void test() {
        System.out.println("通过反射获取成员方法...");
    }

    public void test(String s) {
        System.out.println("获取指定参数的成员方法..." + s);
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

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}