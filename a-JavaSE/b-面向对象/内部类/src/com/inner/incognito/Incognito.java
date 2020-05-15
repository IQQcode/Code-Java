package com.inner.incognito;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 08:47
 * @Description:匿名内部类
 */

interface MyInterface {
    void method();
}

/**匿名内部类---匿名方法*/
public class Incognito {
    public static void main(String[] args) {
        //使用匿名内部类实现接口
        new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法. 匿名对象来调用方法！");
            }
        }.method();
    }
}
