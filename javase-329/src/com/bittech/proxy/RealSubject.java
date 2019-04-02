package com.bittech.proxy;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class RealSubject implements ISubject {
    
    @Override
    public void eat() {
        System.out.println("饿了要吃饭") ;
    }
}
