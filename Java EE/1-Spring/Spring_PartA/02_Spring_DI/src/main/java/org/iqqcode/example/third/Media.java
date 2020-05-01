package org.iqqcode.example.third;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-25 10:01
 * @Description:
 */
public class Media implements Major {

    @Override
    public void listen() {
        System.out.println("数媒专业去听讲座！");
    }

    public boolean experiment() {
        // 星期三的时候数媒专业要做实验
        return true;
    }
}
