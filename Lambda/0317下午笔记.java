内部类:
方法内部类:
定义在方法中,作用域仅限于方法内,不能使用任何权限修饰符。方法参数使用隐式final声明，
即方法内部类只能使用方法参数，无法修改。

匿名内部类:
定义方法中,必须实现一个接口或者继承一个抽象类。

使用Lambda表达式要求接口中有且只有一个抽象方法。
JDK8新增注解@FunctionalInterface
只能用于接口声明，检测当前接口中是否只有一个抽象方法

Lambda表达式语法:
1.方法体实现只有一行
() -> 具体实现代码;

2.方法体有多行实现
() -> {
	方法体实现代码	
};

3.方法若有返回值:
a.只有一行代码，return都可以省略
ISubject subject = (r1,r2) -> r1+r2;
b.方法体有多行代码，此时return不能省略
ISubject subject = (r1,r2) -> {
    r1 = r1 + 10;
    r2 = r2 + 10;
    return r1+r2;
};

方法引用:一般结合Lambda共同使用
引用的方法的具体实现
1.引用某个类的静态方法
ISubject<Integer,String> stringISubject =
    String :: valueOf;
// 等同于使用String.valueOf(10);
stringISubject.switchPara(10)
2.引用某个对象的普通方法
ISubject<String> subject =
    "hello" :: toUpperCase;
// 等同于"hello".toUpperCase();
System.out.println(subject.switchPara());
3.引用某个类的普通方法
ISubject<Integer,String> iSubject =
    String :: compareTo;
// 等同于new String.compareTo("刘","杨");
System.out.println(iSubject.switchPara("刘","杨"));
4.引用某个类的构造方法
ISubject<Person,Integer,String> subject =
    Person::new;
// 等同于new Person(40,"蛋哥");
Person per = subject.createPerson(40,"蛋哥");
System.out.println(per);












反射 : 根据现有对象倒推类的组成

最核心:Class类
任何一个类在JVM中都有唯一的一个class对象,此对象记录该类的组成结构。
当类加载时由JVM产生，用户只能取得此对象无法创建。

要想在Java中应用反射，首先取得该类的class对象。
1.调用Object提供的getClass方法
2.类名称.class
3.调用Class类提供的静态方法Class.forName(类的全名称);



拿到一个类的class对象后
1.创建该类的新对象
public T newInstance() : 使用的是类中<无参构造>进行对象的创建





反射与工厂模式:

class ComputerFatory {
    public static IComputer getInstance(String computerClass) {
        try {
            Class<?> cls = Class.forName(computerClass);
            IComputer computer =
                    (IComputer) cls.newInstance();//强转为接口对象
            return computer;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}


2.取得包名、父类、父接口信息
Package:描述一个类的包信息
Class类提供的getPackage()方法

取得一个类的父类信息:Class
Class类提供的getSuperclass()

取得一个类的所有父接口
Class类提供的getInterfaces() : Class[]  // 取得所有类的父接口，返回数组



3.取得构造方法、普通方法、普通属性
Constructor:描述一个类的构造方法


取得指定参数构造方法
Class类提供的getConstructor(参数) : 只能取得权限为public的构造方法
Class类提供的getDeclaredConstructor(参数) : 可以取得类中所有构造方法，与权限无关

取得所有构造方法
Class类提供的getConstructors() : 只能取得权限为public的构造方法
Class类提供的getDeclaredConstructors() : 可以取得类中所有构造方法，与权限无关



创建新对象:
Constructor类提供的
public T newInstance(Object ... initargs)

若类中没有无参构造，则只能调用Constructor类提供的newInstance()方法，使用有参构造来实例化对象

//动态破坏封装

Method:描述一个类的普通方法


Field:描述一个类的普通属性








