package com.MultiThread;

/**
 * join()等待结束
 *
 * 在一个线程A中执行另外一个线程B的join方法，那么线程A阻塞，直到线程B执行完毕，
 * 线程A继续执行(回到就绪)
 */

/*

class MyRunnableJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " run  i = " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "--> 开始");
        Thread thread = new Thread(new MyRunnableJoin());
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName() + "--> 结束！");
    }
}
*/

/**
 * sleep 休眠，暂停线程，交出CPU，不释放锁（资源）
 *
 * yield 让步，暂定线程，交出CPU（时机不确定），不释放锁;
 *       CPU时间片段只能供相同优先级的线程使用，回到就绪
 */

class MyRunnableJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " run  i = " + i);
        }
    }
}

public class ThreadMethod {
    public static void main(String[] args) {
        MyRunnableJoin myRunnableJoin = new MyRunnableJoin();
        new Thread(myRunnableJoin).start();
        new Thread(myRunnableJoin).start();
        new Thread(myRunnableJoin).start();
    }
}

