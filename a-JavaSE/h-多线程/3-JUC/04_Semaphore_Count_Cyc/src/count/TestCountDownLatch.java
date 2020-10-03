package count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: iqqcode
 * @Date: 2020-10-02 11:33
 * @Description:
 *   - 三个线程任务协同工作，主线程阻塞(await)
 *   - 主线程等待计数为0时被唤醒, 主线程继续执行
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " begin. ");
            try {
                Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end... " + latch.getCount());
        }," -> 线程A");

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " begin. ");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end... " + latch.getCount());
        }," -> 线程B");

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " begin. ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end... " + latch.getCount());
        }," -> 线程C");

        service.submit(() -> {
            System.err.println("主线程等待中...");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("主线程执行！");
        });
    }
}
