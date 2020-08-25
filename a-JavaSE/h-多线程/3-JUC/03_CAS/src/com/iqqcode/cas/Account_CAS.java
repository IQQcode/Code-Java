package com.iqqcode.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: iqqcode
 * @Date: 2020-08-25 17:03
 * @Description:CAS无锁保证安全
 */
public class Account_CAS implements Account {
    private AtomicInteger balance;

    public Account_CAS(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        // 需要不断尝试，直到成功为止
        while (true) {
            // 比如拿到了旧值 1000
            int prev = balance.get();
            // 在这个基础上 1000-10 = 990
            int next = prev - amount;
            /**
             * compareAndSet正是做检查，在Set前，先比较 prev 与当前值
             *     - 不一致，next 作废，返回 false 表示失败
             *            比如，别的线程已经做了减法，当前值已经被减成了 990
             *            那么本线程的这次 990 就作废了，进入 while 下次循环重试
             *     - 一致，以 next 设置为新值，返回 true 表示成功
             */
            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-1 * amount);
    }


    //测试
    public static void main(String[] args) {
        System.out.println("synchronized保证安全:");
        Account.demo(new Account_Sync(10000));
        System.out.println("\nCAS保证安全:");
        Account.demo(new Account_CAS(10000));
    }
}

