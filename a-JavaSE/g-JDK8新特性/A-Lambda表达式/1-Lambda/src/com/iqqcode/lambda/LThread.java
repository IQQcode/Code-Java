package com.iqqcode.lambda;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-27 16:05
 * @Description:Lambda表达式实现Runnable接口
 */
public class LThread {
    public static void main(String[] args) {
        //使用匿名内部类实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "创建了");
            }
        }).start();

        //lambda实现多线程
        new Thread(()-> {
                System.out.println("线程" + Thread.currentThread().getName() + "创建了");
            }
        ).start();
    }
}
