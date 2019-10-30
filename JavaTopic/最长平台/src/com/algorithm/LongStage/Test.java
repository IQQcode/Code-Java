package com.algorithm.LongStage;
import	java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-30 19:24
 * @Description:最大平台问题
 */
public class Test {
    /*public static int subString(char[] elem,int con) {

        return pos;
    }*/

    public static void main(String[] args) {
        String s = "sshs1233343ww3";
        // 转化为字符数组
        char[] elem = s.toCharArray();
        System.out.println(Arrays.toString(elem));
        int maxLength = 0;
        int msg = 0;
        int pos = 0;
        //把每个对应的值以及次数存下来
        for(int i = 0; i < elem.length; i++) {
            if(elem[i+1] == elem[i]) {
                msg++;
                if(msg > maxLength) {
                    maxLength = msg;
                    pos = i + 1;
                }
            }else {
                msg = 0;
            }
        }
        //记录最大平台的元素个数
        maxLength ++;
        for(int i = 0; i < maxLength; i++) {
            System.out.println(elem[pos]);
        }
    }
}

