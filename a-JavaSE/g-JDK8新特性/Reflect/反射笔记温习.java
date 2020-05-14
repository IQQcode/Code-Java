Class类:描述接口与类的组成,Class对象由JVM在第一次加载类时产生，并且全局唯一


一、取得任意类的class对象：

1.调用Object类提供的getClass()方法
2.类名.class
3.调用Class类提供的静态方法 Class.forName(类的全名称)

Data date = new Date();//正向处理

Class<Date> cls = (Class<Date>) date.getClass(); //取得Date()对象的Class对象

Date.class;

Class cls = Class.forName("java.util.Date")


二、newInstance()----> 通过反射产生类的实例化对象：

 * 1.取得Date类的Class对象:

        Class<Date> cls = Date.class;  //取得Date类的class对象
        Date date = cls.newInstance(); //newInstance()实例化对象
        System.out.println(date);

 * 2.取得包名：
        cls.getClass().getName();

 * 3.取得父类的Class对象:
        cls.getSuperclass();

 * 4.取得一个类的父接口:
        Class[] classes = MyClassImpl.class.getInterfaces();//取得父接口
        for(Class msg : classes) {  //父接口为一个或多个，循环输出
            System.out.println(msg);
        }

三、反射调用 构造方法、普通方法、类中属性

1. 反射调用构造方法：

       取得所有构造方法
 * Class类提供的getConstructors() : 只能取得权限为public的构造方法
 *
 * Class类提供的getDeclaredConstructors() : 可以取得类中所有构造方法


        //取得有参构造
        Constructor constructor = cls.getConstructor(String.class,int.class);

        //实例化对象
        //相当于调用 Person per = new Person("大二",20)
        Person per = (Person) constructor.newInstance("大二",20);
        
