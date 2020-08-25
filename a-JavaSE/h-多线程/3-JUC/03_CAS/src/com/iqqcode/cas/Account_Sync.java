package com.iqqcode.cas;

/**
 * @Author: iqqcode
 * @Date: 2020-08-25 17:01
 * @Description:synchronized加锁保证安全
 */
public class Account_Sync implements Account{

    private Integer balance;

    public Account_Sync(Integer balance) {
        this.balance = balance;
    }

    @Override
    public synchronized Integer getBalance() {
        return balance;
    }

    @Override
    public synchronized void withdraw(Integer amount) {
        balance -= amount;
    }


    //测试
    public static void main(String[] args) {
        Account.demo(new Account_Sync(10000));
    }
}
