package com.bittech.proxy;

/**
 * 普通的Java类型
 * 1. 静态代理 无法实现
 * 2. JDK的动态代理  无法实现
 *      1-2代理模式是基于接口的代理
 * 3. extends进行扩展  可以实现
 *
 *
 * Author: secondriver
 * Created: 2019/3/31
 */
public class Message {
    
    public void send() {
        System.out.println("www.bit.java.reflact") ;
    }
}
