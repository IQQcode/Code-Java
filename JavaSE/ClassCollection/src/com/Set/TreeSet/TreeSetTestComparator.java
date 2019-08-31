package com.Set.TreeSet;
import	java.util.Iterator;

import	java.util.TreeSet;
import	java.util.Comparator;
import  java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-27 18:23
 * @Description:TreeSet升序Test,Comparator比较自定义对象的大小
 */

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

/**
 * @比较器  此类专门比较俩个自定义Person的大小
 */
class PersonAgeAsc implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() < o2.getAge()) {
            return - 1;
        }
        if(o1.getAge() > o2.getAge()) {
            return 1;
        }
        return 0;
    }
}

public class TreeSetTestComparator {
    public static void main(String[] args) {
        PersonAgeAsc per = new PersonAgeAsc();
        Set<Person> set = new TreeSet<> (per);
        set.add(new Person("Mr.Q",21));
        set.add(new Person("IQQcode",20));
        set.add(new Person("Mr.Q",22));
        System.out.println(set);
    }
}
