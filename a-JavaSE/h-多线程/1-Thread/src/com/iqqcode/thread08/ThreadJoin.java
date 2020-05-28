package com.iqqcode.thread08;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-28 07:47
 * @Description:Join--线程插队
 */
public class ThreadJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "插队线程来了-->" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin tj = new ThreadJoin();
        Thread thread = new Thread(tj);
        thread.start();
        //主线程任务
        for (int i = 0; i < 100; i++) {
            if (i == 90) {
                thread.join();
            }
            System.out.println("main线程执行" + i);
        }
    }
}
