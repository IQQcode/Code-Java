package com.gui.demo;

import com.gui.red.OpenMode;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 15:29
 * @Description:红包类实现
 * 红包分发的策略：
 * 1.普通红包（平均）：totaLMoney / totalcount，余数放在最后一个红包当中
 * 2.手气红包（随机）：最少1分钱，最多不超过平均数的2倍。应该越发越少
 */
public class RedPacket {
    public static void main(String[] args) {
        MyRed red = new MyRed("大吉大利");
        //设置群主名称
        red.setOwnerName("Mr.Q");

        /*普通红包*/
        /*OpenMode normal = new NormalMode();
        red.setOpenWay(normal);*/

        /*手气红包*/
        OpenMode rand = new RandomMode();
        red.setOpenWay(rand);
    }
}
