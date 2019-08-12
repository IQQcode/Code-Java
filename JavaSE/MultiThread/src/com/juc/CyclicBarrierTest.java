package com.juc;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-12 15:02
 * @Description:CyclicBarrier
 */
class CyclicTest implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicTest(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "写入数据中...");
        try {
            TimeUnit.SECONDS.sleep(3);
            cyclicBarrier.await(); // 所有子线程再次都阻塞
            System.out.println("所有线程都已写入数据完毕！\t同时恢复执行...");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(new CyclicTest(cyclicBarrier),"Writing A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new CyclicTest(cyclicBarrier),"Writing B").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new CyclicTest(cyclicBarrier),"Writing C").start();
    }
}
