package com.MultiThread;

/**
 * 多线程中有三种方式可以停止线程:
 *
 * 1. 设置标记位，可以是线程正常退出。
 *
 * 2. 使用stop方法强制使线程退出，但是该方法不太安全所以已经被废弃了。
 *
 * 3. 使用Thread类中的一个interrupt() 可以中断线程。
 */


/*
class MyThreadStop implements  Runnable {
    private boolean flag = true;
    @Override
    public void run() {
    int i = 0;
    while(flag) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行 i = " + (i++));
    }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class ThreadStop {
    public static void main(String[] args) {
        MyThreadStop threadStop = new MyThreadStop();
        //new Thread(threadStop).start();

        Thread thread1 = new Thread(threadStop);
        thread1.start();
        try {
            Thread.sleep(5000);

            //设置标记为使线程退出
            threadStop.setFlag(false);

            //使用stop方法使线程退出
            //new Thread(threadStop).stop();
            //thread1.stop();

            System.out.println("Main 方法执结束！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
*/


/**
 * 使用Thread.interrupt()中断
 */

class MyThreadStop implements  Runnable {
    private boolean flag = true;
    @Override
    public void run() {
    int i = 0;
    while(flag) {
        try {
            Thread.sleep(1000);
            boolean bool = Thread.currentThread().isInterrupted();
            if(bool) {
                System.out.println("非阻塞情况！线程的中断状态： " + bool);
                break;
            }
            System.out.println("第" +i+ "次执行，线程名称为:" + Thread.currentThread().getName() + "执行 i = " + (i++));
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程中断……");
            System.out.println(Thread.currentThread().isInterrupted());
            //退出循环
            break;
        }
    }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        MyThreadStop threadStop = new MyThreadStop();
        Thread thread = new Thread(threadStop,"子线程A ");
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("Main 方法执结束！");
    }
}
