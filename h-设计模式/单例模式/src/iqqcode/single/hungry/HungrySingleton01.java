package iqqcode.single.hungry;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:41
 * @Description:饿汉式单例---静态变量
 * 饿汉式三个核心组成
 *    1.构造方法私有化
 *    2.类内部提供静态私有域
 *    3.类内部提供静态方法返回唯一对象
 */
class Singletons {
    //唯一的对象在类加载时产生
    private final static Singletons single = new Singletons();

    //构造方法私有化

    private Singletons() { }

    //静态方法-----为什么是静态方法？？
    //因为在类的外部无法产生对象，因此无法调用对象方法
    //通过getter方法取得唯一的对象
    public static Singletons getSingleton(){
        return single;
    }

    public void print() {
        System.out.println("饿汉式单例,上来直接new……");
    }
}

public class HungrySingleton01 {
    public static void main(String[] args) {
        //不能直接new,而是通过 Singleton.getSingleton()静态方法取得类中已经产生好的对象
        Singletons single = Singletons.getSingleton();
        Singletons single1 = Singletons.getSingleton();
        System.out.println(single == single1);
        single.print();
    }
}
