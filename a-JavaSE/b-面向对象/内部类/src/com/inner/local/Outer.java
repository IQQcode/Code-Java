package com.inner.local;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 07:57
 * @Description:成员内部类
 */
public class Outer {
    public void methodOuter() {
        class Inner {  //局部内部类
            int num = 10;
            public void methodInner() {
                System.out.println("调用局部内部类：" + num);
            }
        }
        Inner in = new Inner();
        in.methodInner();
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        out.methodOuter();
    }
}
