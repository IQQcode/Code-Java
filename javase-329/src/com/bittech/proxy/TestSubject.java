package com.bittech.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class TestSubject {
    
    public static void main(String[] args) {
//        ISubject realObject = new RealSubject();//1 -> class
//        ISubject proxyObject = new ProxySubject(realObject);//2 -> class Object
//        proxyObject.eat();
        
        //通过工厂设计模式，代理模式，反射
        /*
        ISubject realObject = ObjectFactory.getObject(RealSubject.class);
        if (realObject != null) {
            ISubject proxyObject = ObjectFactory.getObject(ProxySubject.class, realObject);
            if (proxyObject != null) {
                proxyObject.eat();
            }
        }
        */
        
        //main -> 客户端 使用者
        //再次使用反射
        /*
        ISubject subject = ObjectFactory.getProxyInterface(
                "com.bittech.proxy.RealSubject",
                "com.bittech.proxy.ProxySubject"
        );
        if (subject != null) {
            subject.eat();
        }*/
        
        
        //动态代理技术
        /*
            代理接口
            业务类    业务对象   被代理对象
            代理类    代理对象
            执行的是 代理对象
         */
        ISubject realObject =new RealSubject();
        InvocationHandler handler = new ProxyHandler(realObject);
        //代理类的实例化对象 -> 代理对象
        //JDK
        ISubject proxyObject= (ISubject) Proxy.newProxyInstance(
                realObject.getClass().getClassLoader(),
                new Class[]{ISubject.class},
                handler
        );
        proxyObject.eat();
        System.out.println(proxyObject.getClass());
        
        
        /*
        
          Proxy0 implements ISubject{
             handler
             eat(){
                handler.invoke();
             }
             
          }
        
        
        
         */
    }
}

class ObjectFactory {
    
    public static <T> T getObject(Class classz) {
        try {
            return (T) classz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static <T> T getObject(Class classz, Object object) {
        //Constructor
        
        try {
            //假设代理类实现一个接口
            Constructor constructor = classz.getConstructor(classz.getInterfaces()[0]);
            return (T) constructor.newInstance(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static <T> T getProxyInterface(String realClass, String proxyClass) {
        try {
            Class realClassz = Class.forName(realClass);
            Class proxyCLassz = Class.forName(proxyClass);
            Object realObject = ObjectFactory.getObject(realClassz);
            if (realObject != null) {
                Object proxyObject = ObjectFactory.getObject(proxyCLassz, realObject);
                return (T) proxyObject;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        
    }
}