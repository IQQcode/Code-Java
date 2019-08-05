package com.ThreadPool;

import java.util.concurrent.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-05 08:05
 * @Description:
 */
class ThreadPoolTest implements Callable<String> {
    private Integer tickets = 20;
    @Override
    public String call() throws Exception {
        for (int i = 0; i < tickets; i++) {
            if(tickets > 0)
                System.out.println(Thread.currentThread().getName() +"还剩 "+tickets--+" 票...");
        }
        return Thread.currentThread().getName() + "票卖完了！";
    }
}

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(2,3,
                60,TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();

        for(int i = 0; i < 5; i ++) {
            executor.submit(threadPoolTest); //submit可以提交Callable,Runnable接口
        }
        executor.shutdown();
    }
}
