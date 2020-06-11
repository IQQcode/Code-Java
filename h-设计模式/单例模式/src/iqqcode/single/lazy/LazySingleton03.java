package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:43
 * @Description:懒汉式单例---线程不安全
 * 特点: 当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作.
 */
class Singleton03 {

    private static Singleton03 single;

    //private 声明无参构造
    private Singleton03() { }

    //静态公有方法，当使用到该方法时，才创建对象(懒汉式)
    public static Singleton03 getSingleton(){
        if(single == null) {
            single = new Singleton03();
        }
        return single;
    }

    public void print() {
        System.out.println("懒汉式单例(线程不安全)，用的时候再new产生对象……");
    }
}

public class LazySingleton03 {
    public static void main(String[] args) {
        Singleton03 single = Singleton03.getSingleton();
        Singleton03 single1 = Singleton03.getSingleton();
        System.out.println(single == single1);
        single.print();
    }
}
