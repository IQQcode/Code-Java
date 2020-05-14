package www.bit.java.Hungry;


/**
 * @Author: Mr.Q
 * @Date: 2019-09-13 10:36
 * @Description:饿汉式单例
 *
 * 饿汉式三个核心组成
 *      1.构造方法私有化
 *      2.类内部提供静态私有域
 *      3.类内部提供静态方法返回唯一对象
 */

class Singletons {
    //唯一的对象在类加载时产生
    private static Singletons singleton = new Singletons();

    //private 声明无参构造
    private Singletons() { }

    //静态方法-----为什么是静态方法？？
    //因为在类的外部无法产生对象，因此无法调用对象方法

    //通过getter方法取得唯一的对象
    public static Singletons getSingleton(){
        return singleton;
    }

    public void print() {
        System.out.println("饿汉式单例,上来直接new……");
    }
}


public class HungrySingleton {
    public static void main(String[] args) {
        Singletons singleton = Singletons.getSingleton();
        //取得singleton对象
        //不能直接new,而是通过 Singleton.getSingleton();静态方法取得类中已经产生好的对象
        singleton.print();
    }
}







