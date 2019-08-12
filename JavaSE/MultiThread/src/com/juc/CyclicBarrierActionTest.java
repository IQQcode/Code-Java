package com.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-12 15:02
 * @Description:所有调用await()阻塞的子线程在计数器值减为 0后
 * 随机挑选一个线程执行 barrierAction任务后,所有子线程恢复执行
 */
class CyclicActionTest implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicActionTest(CyclicBarrier cyclicBarrier) {
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
public class CyclicBarrierActionTest {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("\n当前线程为: "+Thread.currentThread().getName()+"\n");
            }
        });
        new Thread(new CyclicTest(cyclicBarrier),"Writing A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new CyclicTest(cyclicBarrier),"Writing B").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new CyclicTest(cyclicBarrier),"Writing C").start();
    }
}
