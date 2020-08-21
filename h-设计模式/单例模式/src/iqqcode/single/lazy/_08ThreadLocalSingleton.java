package iqqcode.single.lazy;

/**
 * @Author: iqqcode
 * @Date: 2020-08-21 09:59
 * @Description:ThreadLocal空间换时间，为每个线程提供资源副本
 */
class ThreadSingleton {
    private ThreadSingleton() { }

    private static final  ThreadLocal<ThreadSingleton> singleton = new ThreadLocal<ThreadSingleton> () {
        @Override
        protected ThreadSingleton initialValue() {
            return new ThreadSingleton();
        }
    };

    public static  ThreadSingleton getInstance() {
        return singleton.get();
    }
}

public class _08ThreadLocalSingleton {
    public static void main(String[] args) {
        ThreadSingleton single = ThreadSingleton.getInstance();
        ThreadSingleton singles = ThreadSingleton.getInstance();
        System.out.println(single == singles);
    }
}
