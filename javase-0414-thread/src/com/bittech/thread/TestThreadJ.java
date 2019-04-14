package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadJ {
    
    public static void main(String[] args) {
        
        Runnable runnable = new MyTickRunnableSyn();
        Thread threadA = new Thread(runnable, "黄牛A");
        Thread threadB = new Thread(runnable, "黄牛B");
        Thread threadC = new Thread(runnable, "黄牛C");
        Thread threadD = new Thread(runnable, "黄牛D");
        
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        
        
    }
    
}

class MyTickRunnableSyn implements Runnable {
    
    private int tick = 30;

//    @Override
//    public void run() {
//        while (this.tick > 0) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //同步的对象（锁，资源）
//            synchronized(this) {
//                //this.tick = this.tick-1
//                if (this.tick > 0) {
//                    System.out.println(Thread.currentThread().getName() + " 买票, 剩余 " + (--this.tick));
//                    if (this.tick == 0) {
//                        System.out.println("票卖光了。。");
//                    }
//                }
//            }
//        }
//    }
    
    @Override
    public void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();//同步方法，同一时间，只能有一个线程访问该方法，进入到该方法
        }
    }
    
    private synchronized void sale() {
        if (this.tick > 0) {
            System.out.println(Thread.currentThread().getName() + " 买票, 剩余 " + (--this.tick));
            if (this.tick == 0) {
                System.out.println("票卖光了。。");
            }
        }
    }
}