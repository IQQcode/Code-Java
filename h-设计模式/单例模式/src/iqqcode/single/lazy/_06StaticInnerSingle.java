package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:46
 * @Description:静态内部类---线程安全
 */
class StaticInner {

    private StaticInner() { }

    //静态内部类
    private static class Singleton {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    public static StaticInner getSingleton() {
        return Singleton.INSTANCE;
    }

    public void print() {
        System.out.println("静态内部类实现的--->线程安全的懒汉式单例");
    }
}

public class _06StaticInnerSingle {
    public static void main(String[] args) {
        StaticInner single = StaticInner.getSingleton();
        single.print();
    }
}