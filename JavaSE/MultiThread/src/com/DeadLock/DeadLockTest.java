package com.DeadLock;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-22 11:18
 * @Description:
 *
 *    死锁: 俩个线程相互在等待对方释放锁资源，无线循环造成死锁
 */

public class DeadLockTest {
    private static Object study = new Object();
    private static Object chat = new Object();

    public static void main(String[] args) {
        //匿名内部类实现方法或接口
        Thread Learning = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (study) {
                    System.out.println("先学习，再撩妹...");
                    synchronized (chat) {
                        System.out.println("好好学习！");
                    }
                }
            }
        });
        Thread girlFriend = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (chat) {
                    System.out.println("先撩妹，再学习...");
                    synchronized (study) {
                        System.out.println("有铝朋友了，学习才有动力，生活才有色彩！");
                    }
                }
            }
        });
        Learning.start();
        girlFriend.start();
    }
}
