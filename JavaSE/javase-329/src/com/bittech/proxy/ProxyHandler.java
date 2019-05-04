package com.bittech.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class ProxyHandler implements InvocationHandler {
    
    //被代理对象 -> RealObject
    private final Object target;
    
    public ProxyHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        prepare();
        Object returnValue = method.invoke(target, args);
        afterEat();
        return returnValue;
    }
    
    /**
     * 对被代理对象（RealObject）的功能的扩展
     */
    public void prepare() {
        System.out.println("饭前收拾食材");
    }
    
    public void afterEat() {
        System.out.println("洗刷刷");
    }
}
