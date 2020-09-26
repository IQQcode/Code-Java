package com.iqqcode;

import org.junit.Test;

import java.util.Random;

/**
 * @Author: iqqcode
 * @Date: 2020-09-26 16:09
 * @Description:
 */
public class Randoms {
    /**
     * new Random()产生随机数
     * <p>
     * 1. 生成区间 [64,128] 中随机值的代码为:  rand.nextInt(65)+ 64;
     * <p>
     * 2. 生成随机三位数的代码为: rand.nextInt(900)+ 100;
     * <p>
     * 3. [公式]: randNumber 将被赋值为一个 [MIN, MAX] 范围内的随机数
     * <p>
     * int randNumber =rand.nextInt(MAX - MIN + 1) + MIN;
     */
    @Test
    public void test1() {
        Random rand = new Random();
        int MAX = 100, MIN = 1;
        for (int i = 0; i < 10; i++) {
            System.out.print(rand.nextInt(MAX - MIN + 1) + MIN + " ");
        }

    }

    /**
     * Math.random() --> double
     * 返回的数值是[0.0,1.0) 的double型数值
     */
    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            int ran = (int) (Math.random() * 100 + 1);
            System.out.print(ran + " ");
        }
    }

    /**
     * 时间戳
     */
    @Test
    public void test3() {
        int max = 100, min = 1;
        long randomNum = System.currentTimeMillis();
        int ran = (int) (randomNum % (max - min) + min);
        //循环同一时间会产生相同的数
        System.out.print(ran);
    }
}
