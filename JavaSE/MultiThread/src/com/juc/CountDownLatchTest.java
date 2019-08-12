package com.juc;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-12 13:56
 * @Description:CountDownLatch阻塞线程,等到子线程减到相应count主线程才继续执行
 */
class CountDownTest implements Runnable {
    private CountDownLatch countDownLatch;

    public CountDownTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"已经到达终点");
        countDownLatch.countDown();
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 主线程等待三个子线程减为 0再恢复执行
        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("Game start...");
        new Thread(new CountDownTest(countDownLatch),"Runner A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new CountDownTest(countDownLatch),"Runner B").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new CountDownTest(countDownLatch),"Runner C").start();
        // 主线程阻塞,等待 Runner A,B,C都到达终点后再执行
        //countDownLatch.await();
        System.out.println("All Runners have reached destination.\nGame end!");
    }
}
