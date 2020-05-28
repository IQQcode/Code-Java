package com.iqqcode.thread02;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 18:48
 * @Description:实现多线程【一】--继承Thread类
 */
class MyThread extends Thread {
    private String thread;
    public MyThread(String thread) {
        this.thread = thread;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(this.thread + " i = " + i);
        }
    }
}

public class ThreadAchieve {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("A"); //A线程会执行10次
        MyThread myThread2 = new MyThread("B"); //B线程会执行10次
        MyThread myThread3 = new MyThread("C"); //C线程会执行10次
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}