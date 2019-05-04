package www.javaSE.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 1.List接口方法的使用
 */

/*
public class CollectionsFramework_List {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.contains(3));
        System.out.println(list.size());
        System.out.println("移除指定元素" + list.remove(2));
        System.out.println(list.get(2));
        System.out.println(list.set(0,7));
        System.out.println(list);
    }
}

*/




/**
 * 2.向集合保存简单的java类对象
 *
 *  equals方法的覆写
 *                 -判断是否为当前对象.true
 *                 --在判断传入的是否为空或者不是当前类的对象.false
 *                 ---向下转型取得 当前类的对象.true
 */



class Person {
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
        //当前对象和传入的对象相同
        if(obj == this) {
            return true;
        }
        //如果为其他类型或者为空
        else if(obj == null) {
            return  false;
        }
        //判断传入的对象是否为 Person()类的子类;如果不是则比较的不是同一个类
        else if(!(obj instanceof  Person)) {
            return  false;
        }
        //上面三个分支都走完，则表示传入的是 Person()的对象，而且和当前的对象不是同一个对象
        //向下转型，还原为 Person()对象
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

public class CollectionsFramework_List {
    public static void main(String[] args) {
        //保存自定义的 Person()对象
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三",20));//匿名对象
        list.add(new Person("李四",18));
        System.out.println(list);
        System.out.println(list.contains(new Person("张三",20)));
        System.out.println(list.remove(new Person("李四",18)));
        System.out.println(list);
    }
}


