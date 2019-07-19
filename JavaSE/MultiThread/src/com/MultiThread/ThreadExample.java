package com.MultiThread;

/**
 * 模拟龟兔赛跑
 */

class Running implements Runnable {
    private  String winner;  //获胜者名字
    @Override
    public void run() {
        for(int steps = 1;steps<=100;steps++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("rabbit") && steps%10==0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"---->" + steps);
            //判断比赛是否结束
            boolean flag = isOver(steps);
            if(flag)
                break;
        }
    }
    private boolean isOver(int steps) {
        if(winner != null)
            return true;
        else {
            if(steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("\n***** Winner is " + winner + " *****");
                return true;
            }
        }
        return false;
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Running run = new Running();
        new Thread(run,"tortoise").start();
        new Thread(run,"rabbit").start();
    }
}
