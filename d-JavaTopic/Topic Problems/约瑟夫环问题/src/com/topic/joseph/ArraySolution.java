package com.topic.joseph;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-07 09:12
 * @Description:数组求解
 * @Solution:
 */
public class ArraySolution {
    /**
     * @param n 围成环人的编号(从1开始到n)
     * @param ans 数到ans的那个人出列
     * @return 幸存人的编号
     */
    public static int joseph(int n, int ans) {
        //开始时设置一个长度为n的数组，并将元素都设为true
        //数组的下标代表人到编号，数组元素的值(T,F)代表是否淘汰
        Boolean[] peopleFlags = new Boolean[n];
        for (int i = 0; i < n; i++) {
            peopleFlags[i] = true;
        }

        //剩下未被淘汰的人数
        int stay = n;
        //计数器，每过一个人加一，加到ans时归零
        int count = 0;
        //标记从哪里开始，index记录了此时数到了第几个人，当index等于总人数n时归零
        //因为是一个圈，所以最后一个人数完后又轮到第一个人数
        int index = 0;
        while (stay > 1) {
            if (peopleFlags[index]) {
                //说明还没有被淘汰 计数器加1
                count++;
                if (count == ans) {
                    count = 0; //计数器归0
                    peopleFlags[index] = false; //此人被淘汰
                    stay--; //未被淘汰的人数-1
                }
            }
            index++;

            //数到本轮最后一人时，则又从第一人开始计数
            if (index == n) {
                index = 0;
            }
        }

        //经过上面的循环，现在数组中被淘汰的人都标记为false，最后没被淘汰都人标记为true
        for (int j = 0; j < n; j++) {
            if (peopleFlags[j]) {
                return j + 1;
            }
        }
        return -1;
    }
}
