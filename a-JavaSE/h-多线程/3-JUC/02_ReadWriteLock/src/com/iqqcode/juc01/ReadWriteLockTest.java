package com.iqqcode.juc01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-08 10:44
 * @Description:读写锁
 */
class MyCache {
    private  volatile Map<String,Object> map = new HashMap<> ();
    //读写锁，更加细粒度控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock lock = new ReentrantLock();

    public void write(String key,Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing " + value);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " write over!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void read(String key) {
        readWriteLock.writeLock().lock();
        try {
            key = Thread.currentThread().getName();
            System.out.println(key + " reading ");
            map.get(key);
            System.out.println(key + " read over");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

}

public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        //写入操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.write(Thread.currentThread().getName(), temp);
            },String.valueOf(i)).start();
        }

        //读取操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.read(Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }
    }
}
