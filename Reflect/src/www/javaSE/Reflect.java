package www.javaSE;

import java.lang.reflect.Constructor;
import  java.util.Date;

/**
 * @反射 : 根据现有对象倒推类的组成
 *
 * 最核心:Class类
 * 任何一个类在JVM中都有唯一的一个class对象,此对象记录该类的组成结构。
 * 当类加载时由JVM产生，用户只能取得此对象无法创建。
 */

/*
class Person {
    int id;
    String name;
    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

public class Reflect {
    public static void main(String[] args) {
        Person per = new Person(18,"刘德华");
        System.out.println(per.getClass());
        System.out.println(per.getClass().getName());
    }
}
*/

/**
 * 取得类的class对象:
 * I.调用 Object提供的 getClass方法
 * II.类名称.class
 * III.调用Class类提供的静态方法 Class.forName(类的全名称);
 */

/*
public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
        //正向处理
        Date data = new Date();//1

        //I.通过对象调用 getClass();方法

        Class<Date> cls = (Class<Date>) data.getClass();
        //取得Data类的Class对象
        System.out.println(cls);//2
        System.out.println(data.getClass().getName());//作用等同于第一、第二句

        //II.通过  类名称.class
        System.out.println(Date.class);

        //III.调用Class类提供的静态方法Class.forName(类的全名称);
        Class msg = Class.forName("java.util.Date");
        System.out.println(msg);
    }
}

*/






/**
 * 通过反射实例化对象：
 * 1.创建该类的新对象(简单工厂模式)
 * 2.取得包名、父类、父接口信息
 * 3.取得构造方法、普通方法、普通属性
 */

/*
interface IMessage { }

interface INews { }

class MyClassImpl implements IMessage,INews { }

public class Reflect {
    public static void main(String[] args) throws Exception {

        Class<Date> cls = Date.class;


        //通过反射取得 Date类对象
        System.out.println("通过反射取得 Date类对象:");
        Date date = cls.newInstance();
        System.out.println(date);


        //取得该类的包名
        System.out.println("取得该类的包名:");
        System.out.println(cls.getPackage().getName());

        //取得父类的Class对象
        System.out.println("取得父类的Class对象:");
        System.out.println(cls.getSuperclass().getName());


        //取得一个类的父接口
        System.out.println("取得一个类的父接口:");
        Class[] classes = MyClassImpl.class.getInterfaces();
        for(Class msg : classes) {
            System.out.println(msg);
        }
    }
}
*/


/**
 * 反射调用构造
 */

class Person {
    private String name;
    private Integer age;

    public Person() { }   //无参构造

    Person(Integer age) {  //default权限的有参构造
        this.age = age;
    }

    private Person(String name,Integer agr) {
        this.name = name;
        this.age = age;
    }
}

/**
 * 取得所有构造方法
 * Class类提供的getConstructors() : 只能取得权限为public的构造方法
 *
 * Class类提供的getDeclaredConstructors() : 可以取得类中所有构造方法
 */

/*public  class Reflect {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person> per = Person.class;    //取得 Person()类的class对象

        //取得所有构造方法
        Constructor[] constructors = per.getDeclaredConstructors();//多个构造方法，放入数组
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
*/


public class Reflect {
    public static void main(String[] args) throws  Exception {
        Class<Person> cls = Person.class;

        //取得有参构造
        Constructor constructor = cls.getConstructor(String.class,int.class);

        //实例化对象
        //相当于调用 Person per = new Person("大二",20)
        Person per = (Person) constructor.newInstance("大二",20);
        System.out.println(per);
    }
}
