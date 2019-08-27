package com.ThreadPool;

import java.util.concurrent.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-05 09:02
 * @Description:
 */
class CallableThread implements Callable<String> {
    private Integer tickets = 30;
    @Override
    public String call() throws Exception {
        for (int i = 0; i < tickets; i++) {
            if(tickets > 0) {
                System.out.println(Thread.currentThread().getName() +"还剩 "+tickets--+" 票...");
            }
        }
        return Thread.currentThread().getName() + "票卖完了！";
    }
}

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程池创建线程
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,5,
                        60,TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>());

        CallableThread callableThread = new CallableThread();
        // Future接口接收 Callable的返回值
        Future<String> future = null;
        for (int i = 0; i < 5; i++) {
             future = threadPoolExecutor.submit(callableThread);
        }
        //----------------- main - ---------------
        System.out.println(future.get());

        // 单线程模式 get()会阻塞当前线程，直到有返回值为止
      /*
       for (int i = 0; i < 5; i++) {
           Future<String> future0 = threadPoolExecutor.submit(callableThread);
           //----------------- main - ---------------
           System.out.println(future0.get());
       }
       */
        threadPoolExecutor.shutdown();
    }
}

