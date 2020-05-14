package com.ThreadPool;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-07 09:17
 * @Description:
 */
// 线程1任务
class StepOne implements Callable<String> {
    private FutureTask<String> futureTask;

    public StepOne(FutureTask<String> futureTask) {
        this.futureTask = futureTask;
    }

    @Override
    public String call() throws Exception {
        System.out.println("T1：洗水壶.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T1:烧开水..");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("T1:等待茶叶...");
        // 线程1阻塞到此处一直等到线程2返回为止
        String str = futureTask.get();
        System.out.println("T1:拿到茶叶....");
        System.out.println("泡茶");
        return "上茶~~~";
    }
}

// 线程2任务
class StepTwo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("T2:洗茶壶*");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2:洗茶杯**");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2:拿茶叶***");
        TimeUnit.SECONDS.sleep(3);
        return "龙井";
    }
}

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask step2 = new FutureTask(new StepTwo());
        FutureTask step1 = new FutureTask(new StepOne(step2));
        new Thread(step1).start();
        new Thread(step2).start();
        // 主线程在step1,step2执行完之后再执行
        System.out.println(step1.get());
    }
}
