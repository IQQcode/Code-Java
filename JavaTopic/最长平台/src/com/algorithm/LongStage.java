package com.algorithm;
import	java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-30 19:24
 * @Description:最长平台问题
 * input : sshs1233343ww3
 * output : 333
 */
public class LongStage {
    public static int[] subString(char[] elem, int maxLength, int pos) {
        int msg = 0;
        //把每个对应的值以及次数存下来
        for(int i = 0; i < elem.length - 1; i++) {
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
        maxLength++;
        return new int[] { maxLength, pos };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        //String s = "sshs1233343ww3";
        // 转化为字符数组
        char[] elem = s.toCharArray();
        System.out.println(Arrays.toString(elem));
        int maxLength = 0;
        int position = 0;
        int[] temp = subString(elem,maxLength,position);
        System.out.println("The Max Stage is: " );
        for(int i = 0; i < temp[0]; i++) {
            System.out.print(elem[position] + " ");
        }
    }
}