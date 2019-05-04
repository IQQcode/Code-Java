package com.bittech.thread;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class TestThreadPoolExecutor {
    
    public static void main(String[] args) throws InterruptedException {
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(20),
                new ThreadFactory() {
                    private final AtomicInteger id = new AtomicInteger(0);
                    
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("Thread-Handler-DataAnalysis-" + id.getAndIncrement());
                        //1.设置名字
                        //2.设置优先级
                        //3.设置是否守护线程
                        return thread;
                    }
                }
                ,
                new ThreadPoolExecutor.DiscardPolicy());
        //pool-index1-thread-index2
        for (int i = 0; i < 10; i++) {
            //无返回值的任务
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now());
                }
            });
        }
        
        /*
        
        executor.shutdown();//会将正在执行的任务执行完成
        executor.shutdownNow(); //不一定将任务执行完
        
        executor.isShutdown();//调用了shutdown shutdownNow
        
        executor.isTerminated();//所有任务关闭
//        executor.isTerminating();
*/
        
        Thread.sleep(1000);
        if (!executor.isShutdown()) {
            executor.shutdown();
            Thread.sleep(2000);
            if (executor.isTerminated()) {
                System.out.println(" Terminated");
            } else {
                System.out.println(" Terminating ");
            }
        }

//        List<Future<String>> futureList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Future<String> future = executor.submit(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return "Call " + Thread.currentThread().getName() + " " + LocalDateTime.now().toString();
//                }
//            });
////            try {
////                System.out.println(future.get());
////            } catch (ExecutionException e) {
////                e.printStackTrace();
////            }
//
//            futureList.add(future);
//        }


//        for (Future future : futureList) {
//            try {
//                System.out.println(future.get());
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
