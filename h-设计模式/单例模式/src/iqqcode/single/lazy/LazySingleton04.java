package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:44
 * @Description:懒汉式单例---同步方法(效率太低)
 */
class Singleton04 {

    private static Singleton04 single;

    //private 声明无参构造
    private Singleton04() { }

    //静态公有方法，当使用到该方法时，才创建对象(懒汉式)
    public synchronized static Singleton04 getSingleton(){
        if(single == null) {
            single = new Singleton04();
        }
        return single;
    }

    public void print() {
        System.out.println("懒汉式单例(线程安全)，同步方法效率太低");
    }
}

public class LazySingleton04 {
    public static void main(String[] args) {
        Singleton04 single = Singleton04.getSingleton();
        single.print();
    }
}