package com.iqqcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-06 10:42
 * @Description:
 */
public class MergeTwoArrays_Three {
    //方法一：
    private static void method1(int a[],int b[],int array[]) {
        //建立c数组，并将a添加进去
        int c[]= Arrays.copyOf(a, a.length+b.length);
        //将b数组添加到已经含有a数组的c数组中去
        System.arraycopy(b, 0, c, a.length, b.length);
        //对c数组进行排序
        Arrays.sort(c);
        System.out.println("方法一：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]+" ");
        }
    }

    //方法二:集合方法  使用LinkedList 队列
    private static void method2(int array[], LinkedList<Integer> queue_a, LinkedList<Integer> queue_b ) {
        //每循环一次，添加一个最小元素进入arrays
        for (int i = 0; i < array.length; i++) {
            //两个队列都不为空时，谁小取出谁
            if (!queue_a.isEmpty()&&!queue_b.isEmpty()) {
                if (queue_a.peek()<queue_b.peek()) {
                    array[i]=queue_a.poll();
                    continue;
                }else {
                    array[i]=queue_b.poll();
                    continue;
                }
            }
            //当数组a为空时，取数组b的元素
            if (queue_a.isEmpty()&&!queue_b.isEmpty()) {
                array[i]=queue_b.poll();
                continue;
            }
            //当数组b为空时，取数组a的元素
            if (queue_b.isEmpty()&&!queue_a.isEmpty()) {
                array[i]=queue_a.poll();
                continue;
            }
        }
        System.out.println("方法二：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    //方法三：递归方法
    private static int [] method3(int a[],int a_start,int b[],int b_start,int array[],int array_start) {

        //若数组a中的元素都已经放到array数组中，而数组b未全部放到array中，
        //那么将b中剩余的元素放到array中
        if (a_start>=a.length) {
            for (int i = array_start; i < array.length; i++) {
                array[array_start]=b[b_start++];
            }
            return array;
        }
        //若数组b中的元素都已经放到array数组中，而数组a未全部放到array中，
        //那么将a中剩余的元素放到array中
        if (b_start>=b.length) {
            for (int i = array_start; i < array.length; i++) {
                array[array_start]=a[a_start++];
            }
            return array;
        }
        //将数组的头元素,b数组头元素 中的最小值赋予给array
        if (a[a_start]<b[b_start]) {
            array[array_start]=a[a_start];
            return	  method3(a, a_start+1, b, b_start,  array, array_start+1);
        }else {
            array[array_start]=b[b_start];
            return	  method3(a, a_start, b, b_start+1, array, array_start+1);
        }

    }


    public static void main(String[] args) {
        int a[]={0,1,5,6,7,9,14};
        int b[]={2,4,8,10,13};
        LinkedList<Integer> queue_a=new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            queue_a.offer(a[i]);
        }
        LinkedList<Integer> queue_b=new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            queue_b.offer(b[i]);
        }
        int array[]=new int[a.length+b.length];

        method1(a, b, array);
        System.out.println();
        method2(array, queue_a, queue_b);
        System.out.println("\n方法三：");
        int all[]=method3(a, 0, b, 0, array, 0);
        for (int i : all) {
            System.out.print(i+" ");
        }
    }
}
