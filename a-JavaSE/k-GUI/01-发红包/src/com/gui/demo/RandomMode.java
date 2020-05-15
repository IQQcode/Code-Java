package com.gui.demo;

import com.gui.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 16:07
 * @Description:随机红包
 */
public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList <>();
        //随机分配，有可能多，有可能少
        //最少1分钱，最多不超过剩下金额平均数的2倍”
        //第一次发红包，随机范围是0.01元~6.66元第一次发完之后，剩下的至少是3.34元
        //此时还需要再发2个红包
        //此时的再发范围应该是0.01元~3,34元（取不到右边，剩下0.01）
        //总结一下，范围的【公式】是：1 + random.nextInt(lastMoney / lastCount * 2);
        Random rand = new Random();
        //totalMoney是总金额， totalcount是总份数，不变
        //额外定义两个变量，分别代表剩下多少钱，剩下多少份
        int lastMoney = totalMoney;
        int lastCount = totalCount;

        //随机发前n-1个，最后一个不需要随机
        for (int i = 0; i < totalCount - 1; i++) {
            int moey = 1 +rand.nextInt(lastMoney / lastCount * 2);
            list.add(moey);
            lastMoney -= moey;
            lastCount--;
        }
        list.add(lastMoney);
        return list;
    }
}
