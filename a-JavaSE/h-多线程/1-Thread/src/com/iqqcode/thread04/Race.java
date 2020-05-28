package com.iqqcode.thread04;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 10:51
 * @Description:并发问题--龟兔赛跑
 */
class Rumming implements Runnable {

    private String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //兔子的线程每隔10步休眠10ms,保证乌龟获胜
            if (Thread.currentThread().getName().equals("兔子") && i%10 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println("执行线程任务时出现异常...");
                }
            }
            System.out.println(Thread.currentThread().getName() +"---->" + i);
            boolean flag = gameOver(i);
            if (flag)
                break;
        }
    }

    public boolean gameOver(int steps) {
        //有胜利者产生
        if (winner != null) {
            return true;
        }else {
            if(steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("\n***** Winner is " + winner + " !!!*****");
                return true;
            }
        }
        return false;
    }
}

public class Race {
    public static void main(String[] args) {
        Rumming run = new Rumming();
        new Thread(run,"兔子").start();
        new Thread(run,"乌龟").start();
    }
}
