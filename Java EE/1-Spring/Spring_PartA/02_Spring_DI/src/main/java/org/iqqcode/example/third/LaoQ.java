package org.iqqcode.example.third;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-25 09:23
 * @Description:
 */
public class LaoQ {
    public void advice() {
        //通知数媒专业听讲座
        new Media().listen();
    }

    public void advice1() {
        System.err.println("数媒专业在做实验...");
        //通知软工专业听讲座
        new Soft().listen();
    }
}