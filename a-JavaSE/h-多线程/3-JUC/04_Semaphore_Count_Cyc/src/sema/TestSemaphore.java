package sema;

import java.text.SimpleDateFormat;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-02 10:55
 * @Description:信号量-用来限制访问共享资源的线程上限
 */
public class TestSemaphore {
    public static void main(String[] args) {
        // 0. 时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        // 获取当前时间
        Date date = new Date();
        // 输出已经格式化的现在时间（24小时制）
        //System.out.println("现在时间：" + sdf.format(date));

        // 1. 创建Semaphore对象
        Semaphore semaphore = new Semaphore(3);
        // 2. 10个线程同时运行
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " start. " + sdf.format(date));
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " end... " + sdf.format(date));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
