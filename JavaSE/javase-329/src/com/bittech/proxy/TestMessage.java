package com.bittech.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Author: secondriver
 * Created: 2019/3/31
 */
public class TestMessage {
    
    public static void main(String[] args) {
        
        //1.业务对象 被代理对象
        Message realObject = new Message();
        
        //2.增强的业务能力对象
        MethodInterceptor interceptor = new MessageExtend(realObject);

        //3.代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(realObject.getClass());
        enhancer.setCallback(interceptor);
        //Object -> Message 向下类型转换 CCE
        //Object instance Message true
        Message proxyObject = (Message) enhancer.create();
        proxyObject.send();
        System.out.println(proxyObject.getClass());
        
        
        
    }
}
