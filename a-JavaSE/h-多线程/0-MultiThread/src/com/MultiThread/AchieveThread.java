package com.MultiThread;
import	java.util.concurrent.Executors;
import	java.util.concurrent.ExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * java实现多线程：
 *
 * 1.继承Thread{ }类;
 * 2.Runnable接口;
 * 3.Callable实现(return ->);
 */

//一、继承 Thread


/*
class MyThread extends Thread {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(this.title + " i = " + i);
        }
    }
}

public class AchieveThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

*/




//二、Runnable接口


/*
class MyThread implements Runnable {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(this.title + " i = " + i);
        }
    }
}

public class AchieveThread {
    public static void main(String[] args) {
        //I. Thread类提供的构造方法接收 Runnable对象

        // public Thread(Runnable target)

        // MyThread mt = new MyThread();
        // new Thread(mt).start();

        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");

        //Runnable 类的对象传入 Thread中
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();

        //II. 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //III. Lambda表达式
        Runnable runnable = () -> System.out.println("Lambda表达式实例化Runnable对象");
        new Thread(runnable).start();

    }
}
*/



//三、Callable实现多线程

/*
class  MyThread implements Callable<String> {
    private Integer tickets = 6;

    @Override
    //线程需要执行的任务 call()
    public String call() throws  Exception {
        while(this.tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " 剩余票数为" + (this.tickets--));
        }
        return Thread.currentThread().getName() + " 票卖完了……";
    }
}

public class AchieveThread {
    public static void main(String[] args) throws Exception {
        // Future: 接收Callable接口的返回值
        // FutureTask 在多线程并发下可以保证任务(传入的Callable或Runnable)只执行一次

        FutureTask<String> task = new FutureTask<>(new MyThread());

        //Callable 类的对象传入 Thread中
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
    }
}
*/


// 四、线程池

class  MyThread implements Callable<String> {
    private Integer tickets = 20;

    @Override
    //线程需要执行的任务 call()
    public String call() throws  Exception {
        while(this.tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " 剩余票数为" + (this.tickets--));
        }
        return Thread.currentThread().getName() + " 票卖完了……";
    }
}

public class AchieveThread {
    public static void main(String[] args) throws Exception {
        // Future: 接收Callable接口的返回值
        // FutureTask 在多线程并发下可以保证任务(传入的Callable或Runnable)只执行一次

        //缓存线程池创建线程
        ExecutorService exec = Executors.newCachedThreadPool();
        Callable<String> callable = new MyThread();
        for(int i = 0;i < 3; i++) {
            exec.submit(callable);
        }
        exec.shutdown();
    }
}



