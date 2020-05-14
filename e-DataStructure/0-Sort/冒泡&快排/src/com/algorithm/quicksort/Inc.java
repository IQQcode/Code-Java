package com.algorithm.quicksort;

import java.util.Random;
/**
 * @Author: Mr.Q
 * @Date: 2019-10-26 17:16
 * @Description:基础快排优化
 */

public class Inc {
    public static void quickSort(int[] array) {
        long start = System.currentTimeMillis();
        int len = array.length;
        //判断待排序数组是否为空数组或只含有一个元素，若是则直接返回
        if(len <= 1) {
            return;
        }
        quickSortInternal(array,0,len-1);
        long end = System.currentTimeMillis();
        System.out.println("基础快排耗时："+ (end-start) +"毫秒");
    }

    /**
     * 基准区间的左右递归
     */
    private static void quickSortInternal(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        //确定基准数(分区点)最终位置
        int pivot = partition(array, left, right);
        //左边区间(小于基准数元素)
        quickSortInternal(array, left, pivot - 1);
        //右边区间(大于基准数元素)
        quickSortInternal(array, pivot + 1, right);
    }

    /**
     * 对数组array[l...r]部分进行partition操作
     * 返回pivot,使得array[l+1...p-1]<array[p],array[p+1...r]>=array[p]</array[p],array[p+1...r]>
     * @param array 待排序数组
     * @param l 数组开始点
     * @param r 数组结束点
     * @return 分区点下标
     */
    private static int partition(int[] array,int l,int r){
        //默认比较元素为待排序数组的第一个元素
        int v = array[l];
        //[l+1...j]为<v的元素区间（刚开始为空区间，随着<v元素的加入区间加长）
        int j = l;
        //[j+1...i-1]为>=v的元素区间（刚开始为空区间，随着>=v元素的加入区间加长）
        //i下标作用在于遍历除比较元素外的其他元素，即从第二个元素开始到结尾
        //遍历数组
        for(int i = l + 1; i <= r; i++) {
            //当大于等于v时保持不动即可，<v时放置j下标区间
            if(array[i] < v) {
                swap(array,i,j+1);
                j++;
            }
        }
        //此时<v元素在前面，>=v元素在后面区间，将<v元素区间的最后一个元素与比较元素交换即可以达到最终效果（区分点元素到达最终位置，<v的元素在区分点左边区间，>=v的元素在区分点右边区间）
        swap(array,l,j);
        //返回区分点下标
        return j;
    }

    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    //生成随机数字
    public static int[] generateRandomArray(int n,int rangeL,int rangeR){
        if(rangeL>rangeR){
            throw new IndexOutOfBoundsException("越界异常");
        }
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = new Integer(new Random().nextInt(rangeR-rangeL+1)+rangeL);
        }
        return arr;
    }

    public static void main(String[] args) {
        //随机生成一万个整数，在10-20000区间
        int[] data = generateRandomArray(10000,10,20000);
        quickSort(data);
    }
}
