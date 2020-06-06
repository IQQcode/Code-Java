package com.iqqcode.table;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-01 08:44
 * @Description:JavaBean存储表格
 * - 每一行使用JavaBean对象
 * - 整张表格使用Map/List
 */
class Student {
    private int id;
    private String name;
    private int age;
    private String graduation;

    public Student() { }

    public Student(int id, String name, int age, String graduation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.graduation = graduation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", graduation=" + graduation +
                '}';
    }
}

public class BeanTable {
    public static void main(String[] args) {
        Student stu1 = new Student(1001,"张三",18,"2020-09");
        Student stu2 = new Student(1002,"李四",20,"2021-07");
        Student stu3 = new Student(1003,"王五",22,"2017-07");

        List<Student> list = new ArrayList<> ();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        for (Student stu : list) {
            System.out.println(stu);
        }

        System.out.println("\n" +"------------------------------------------------" + "\n");

        Map<Integer,Student> map = new HashMap<> ();
        map.put(1001,stu1);
        map.put(1002,stu2);
        map.put(1003,stu3);
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(map.get(key));
        }
    }
}
