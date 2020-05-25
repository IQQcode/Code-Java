package com.iqqcode.thread03;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 20:18
 * @Description:匿名内部类创建线程
 */
public class InnerClassAchieve {
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
        new Thread(run).start();

        //简化接口的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->>>" + i);
                }
            }
        }).start();
    }
}
