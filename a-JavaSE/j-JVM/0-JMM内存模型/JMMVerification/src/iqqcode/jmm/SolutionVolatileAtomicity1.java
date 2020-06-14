package iqqcode.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-13 08:54
 * @Description:CAS解决volatile原子性问题
 */
public class SolutionVolatileAtomicity1 {

    //使用原子操作类
    public static AtomicInteger num = new AtomicInteger(0);

    public static void increase() {
        //原子性的num++,通过循环CAS方式
        num.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

        //主线程阻塞，等待线程数组中的10个线程执行完再继续执行
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num); // num = 1000 * 10
    }
}
