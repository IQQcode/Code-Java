package www.bit.java.Lazy;


/**
 * @Author: Mr.Q
 * @Date: 2019-09-13 10:50
 * @Description:线程安全的懒汉式单例
 */

/**
 * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()这句，这并非是一个原子操作，
 * 事实上在 JVM 中这句话大概做了下面 3 件事情。 给 instance 分配内存 调用 Singleton 的构造函数来初始化成员变
 * 量 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了） 但是在 JVM 的即时编译器中存在指
 * 令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-
 * 2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初
 * 始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。 我们只需要将 instance 变量声明成
 * volatile 就可以了
 */
class SafeSingleton {
    private volatile static SafeSingleton singleton = null;

    private SafeSingleton() { }

    //同步方法上锁
    /*public static synchronized SafeSingleton getSingleton() {
        if(singleton == null) {
            singleton = new SafeSingleton();
        }
        return singleton;
    }*/

    //同步代码块上锁
    public static SafeSingleton getSingleton() {
        if(singleton == null) {
            synchronized (SafeSingleton.class) {
                if (singleton == null) {
                    singleton = new SafeSingleton();
                }
            }
        }
        return singleton;
    }

    public void fun() {
        System.out.println("synchronized修饰同步代码块,线程安全的懒汉式单例");
    }
}
public class ThreadSafeSingleton {
    public static void main(String[] args) {
        //静态方法取得类中已经产生好的对象
        SafeSingleton singleton = SafeSingleton.getSingleton();
        singleton.fun();
    }
}
