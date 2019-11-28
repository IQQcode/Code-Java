package com.bufferAndbuilder;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-28 19:07
 * @Description:
 */
public class TestBuffer {
    public static void main(String[] args) {
        //获取开始时间
        Long start1 = System.currentTimeMillis();
        //String Test
        for (int i = 0;i < 100000;i++) {
            String str = "a";
            str += "b";
        }
        //获取结束时间
        Long end1 = System.currentTimeMillis();
        //打印出花费的时间
        System.out.println("String花费时间："+ (end1-start1));

        //StringBuilder Test
        Long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000;i++) {
            StringBuilder str2 = new StringBuilder("a");
            str2.append("b");
        }
        Long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder花费时间："+(end2-start2));

        //重复10万次进行StringBuffer变量加操作
        Long start3 = System.currentTimeMillis();
        for (int i=0;i < 100000;i++)
        {
            StringBuffer str2 = new StringBuffer("a");
            str2.append("b");
        }
        Long end3 = System.currentTimeMillis();
        System.out.println("StringBuffer花费时间："+(end3-start3));
    }
}
