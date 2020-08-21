package com.iqqcode.thread03;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 20:18
 * @Description:Lambda简化Runnable书写
 */
public class Lambda_Simplify {
    public static void main(String[] args) {
        //Thread实现
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "->" + i);
                }
            }
        }.start();

        //Runnable接口
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->>" + i);
                }
            }
        };
        new Thread(run, "接口简化").start();

        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->>>" + i);
                }
            }
        }, "匿名内部类").start();


        //Lambda
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "===>->" + i);
            }
        }, "Lambda").start();
    }
}
