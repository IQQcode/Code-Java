package www.bit.java;

//***单例

//单例模式：类的对象有且只有一个

//首先控制对象的产生数量--将构造方法私有化(从源头控制对象数量 new Person();)

//构造方法私有化：任何其他类均无法参生此对象(本质是任何他类均无法调用构造方法,所以无法产生对象)
//对象的产生？？？
//  Person  per = new   Person();

//唯一的一个对象产生于类内部

//唯一的属性为静态属性，并且类中提供静态方法取得此对象


//*************饿汉式单例***********

// 饿汉式三个核心组成------
// 1.构造方法私有化
// 2.类内部提供静态私有域
// 3.类内部提供静态方法返回唯一对象


class Singleton {
    //类中提供了一个对象
    private static Singleton singleton = new Singleton();//所有普通属性拿private封装
    private Singleton() { }

    //静态方法-----为什么是静态方法？？
    //因为在类的外部无法产生对象，因此无法调用对象方法
    public static Singleton getSingleton(){  //通过getter方法取得唯一的对象
        return singleton;
    }

    public void print() {
        System.out.println("Hello World");
    }
}



//************ 懒汉式单例 ****************

//特点：当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作.


class Singleton {
    //类加载时产生
    private static Singleton singleton;
    private Singleton() { }
    //静态方法
    public static Singleton getSingleton(){
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton ;
    }

    public void print() {
        System.out.println("Hello World");
    }
}





public class Test {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        //取得singleton对象，不能直接new；
        //而是通过 Singleton.getSingleton();静态方法取得类中已经产生好的对象

        //singleton1.print();

        Singleton singleton2 = null ; // 声明对象
        singleton2 = Singleton.getSingleton() ;
        singleton2.print();

    }
}

