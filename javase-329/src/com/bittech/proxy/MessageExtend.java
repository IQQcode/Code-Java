package com.bittech.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/3/31
 */
public class MessageExtend implements MethodInterceptor {
    
    private final Object target;
    
    public MessageExtend(Object target) {
        this.target = target;
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("扩展的代码(B)，此处省略。。。。1w");
        Object returnValue= method.invoke(target,args);//业务对象自己的方法
        System.out.println("扩展的代码(A)，此处省略。。。。1w");
        return returnValue;
    }
}
