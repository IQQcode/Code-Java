package com.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:1.向集合保存简单的java类对象
 * @Description:2.覆写equals()
 *  equals方法的覆写
 *  1.判断是否为当前对象.true
 *  2.在判断传入的是否为空或者不是当前类的对象.false
 *  3.向下转型取得 当前类的对象.true
 */

class Person {
    //自定义的类中属性必须使用包装类
    private String name;
    private Integer age;

    public Person(String name,Integer age) {
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
    public boolean equals(Object obj) {
        //当前对象和传入的对象地址是否相同
        if(obj == this) {
            return true;
        }
        //如果为其他类型或者为空
        else if(obj == null) {
            return  false;
        }
        //判断传入的对象是否为 Person()类的子类;如果不是则比较的不是同一个类(Person & Dog)
        else if(!(obj instanceof  Person)) {
            return  false;
        }
        //上面三个分支都走完，则表示传入的是 Person()的对象,而且和当前的对象不是同一个对象
        //向下转型，还原为 Person()对象,取出属性值比较
        Person per = (Person) obj;
        return this.name.equals((per.name)) && this.age.equals(per.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ListAddClass {
    public static void main(String[] args) {
        //保存自定义的 Person()对象
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三",20));//匿名对象
        list.add(new Person("李四",18));
        System.out.println(list);
        // new 的原因:未知集合中是否存在目标对象，new创建之后再比较
        System.out.println(list.contains(new Person("张三",20)));
        System.out.println(list.remove(new Person("李四",18)));
        System.out.println(list);
    }
}


