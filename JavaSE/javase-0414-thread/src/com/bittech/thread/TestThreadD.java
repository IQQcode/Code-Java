package com.bittech.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 验证：
 * Thread和Runnable的业务共享问题
 * <p>
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadD {
    
    public static void main(String[] args) {
        //该三个线程业务处理没有关系
//        new MyTickThread().start();
//        new MyTickThread().start();
//        new MyTickThread().start();
//        MyTickRunnable target = new MyTickRunnable();
//        new Thread(target).start();
//        new Thread(target).start();
//        new Thread(target).start();
        
        Callable<String> callable = new MyTickCallable();
        FutureTask<String> future = new FutureTask<>(callable);
        new Thread(future).start();
        new Thread(future).start();
        
        try {
            //获取线程指定之后的返回结果，阻塞操作
            String returnValue = future.get();
            System.out.println(returnValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        
    }
}

class MyTickThread extends Thread {
    
    private int tick = 10;
    
    @Override
    public void run() {
        while (this.tick > 0) {
            System.out.println("-- 剩余票数 " + --this.tick + " --");
        }
    }
}

class MyTickRunnable implements Runnable {
    private int tick = 10;
    
    @Override
    public void run() {
        while (this.tick > 0) {
            System.out.println("-- 剩余票数 " + --this.tick + " --");
        }
    }
}

class MyTickCallable implements Callable<String> {
    
    private int tick = 10;
    
    @Override
    public String call() throws Exception {
        while (this.tick > 0) {
            System.out.println("-- 剩余票数 " + --this.tick + " --");
        }
        return "票卖完了。。。";
    }
}