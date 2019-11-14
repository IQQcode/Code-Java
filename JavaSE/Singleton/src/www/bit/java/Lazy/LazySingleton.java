package www.bit.java.Lazy;


/**
 * @Author: Mr.Q
 * @Date: 2019-09-13 10:34
 * @Description:懒汉式单例
 * 特点: 当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作.
 */
class Singleton {
    private static Singleton singleton;
    //private 声明无参构造
    private Singleton() { }

    public static Singleton getSingleton(){
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public void print() {
        System.out.println("懒汉式单例，用的时候再new产生对象……");
    }
}


public class LazySingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton() ;
        singleton.print();
    }
}

