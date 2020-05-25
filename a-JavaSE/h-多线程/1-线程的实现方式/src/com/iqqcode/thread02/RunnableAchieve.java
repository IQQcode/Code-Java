package com.iqqcode.thread02;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 18:48
 * @Description:实现多线程【一】--继承Thread类
 */
class MyRunnable implements Runnable {
    private String thread;
    public MyRunnable(String thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(this.thread + " i = " + i);
        }
    }
}

public class RunnableAchieve {
    public static void main(String[] args) {
        //实例化Runnable接口的实现类
        MyRunnable run1 = new MyRunnable("A");
        MyRunnable run2 = new MyRunnable("B");
        MyRunnable run3 = new MyRunnable("C");
        //创建 Thread类对象，构造方法中传递 Runnable接口的实现类对象
        //调用 Threa类中的start方法，开启新的线程来执行run方法
        new Thread(run1).start();
        new Thread(run2).start();
        new Thread(run3).start();
    }
}