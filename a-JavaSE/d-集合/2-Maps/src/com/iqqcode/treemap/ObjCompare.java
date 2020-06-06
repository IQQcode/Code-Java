package com.iqqcode.treemap;
import	java.util.HashMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-31 15:14
 * @Description:TreeMap自定义对象的排序
 */
class Person implements Comparable<Person>{
    int id;
    String name;
    int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        }else {
            //年龄相同按照id比较
            if (this.id > o.id) {
                return 1;
            }else if (this.id < o.id) {
                return -1;
            }else {
                return 0;
            }
        }
    }
}
public class ObjCompare {
    public static void main(String[] args) {
        Map<Person,String> treemap = new TreeMap<>();
        treemap.put(new Person(1001,"张三",18),"2020-01");
        treemap.put(new Person(1002,"李四",20),"2020-02");
        treemap.put(new Person(1003,"王五",18),"2020-03");
        for (Person per : treemap.keySet()) {
            String value = treemap.get(per);
            System.out.println("key: " + per + "   value: " + value);
        }
    }
}
