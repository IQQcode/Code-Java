package com.iqqcode.loaal;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-16 08:31
 * @Description:
 */
class LocalTest implements Runnable {
    //线程私有属性
    private ThreadLocal tl;

    public LocalTest(ThreadLocal tl) {
        this.tl = tl;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                tl.set(Thread.currentThread().getName() + (i+1));
                System.out.println(Thread.currentThread().getName() + " -->> " + tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        LocalTest run = new LocalTest(tl);
        new Thread(run, "A").start();
        new Thread(run, "B").start();
    }
}
