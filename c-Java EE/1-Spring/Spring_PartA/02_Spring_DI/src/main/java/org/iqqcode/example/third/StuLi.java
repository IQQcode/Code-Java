package org.iqqcode.example.third;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-25 10:04
 * @Description:
 */
public class StuLi {
    public static Major getListen() {
        Media media = new Media();
        if (media.experiment()) {
            //如果数媒有实验就通知软工去
            return new Soft();
        }
        return media;
    }
}
