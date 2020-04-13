package iqqocde.algorithm.sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-12 21:32
 * @Description:归并排序
 * left: 记录数组中的最小索引
 * right:记录数组中的最大索引
 * temp: 辅助数组
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        //初始化辅助数组
        int[] temp = new int[arr.length];
        //安全性校验
        if(low < high) {
            //中间索引将low与high之间的数据分为两组
            int mid = low + (high-low)/2;
            //对两组数据分别进行递归排序
            //向左递归进行分解排序
            mergeSort(arr, low, mid);
            //向右递归进行分解排序
            mergeSort(arr, mid+1, high);
            //将两组排好序的子序列进行归并再排序
            merge(arr, low, high, mid, temp);
        }
    }

    /**
     * 从low到mid为一组，从mid+1到high为一组，对这两组数据进行归并
     * 归并方法：通过三指针的移动，将左右子序列重新再排序放入到辅助数组中，然后将辅助数组中的有序序列放回到源数组
     * @param arr 待排序的数组
     * @param low 左子有序序列的初始索引
     * @param high 右子有序序列的末位索引
     * @param mid 中间索引
     * @param temp 做中转的辅助数组
     */
    public static void merge(int[] arr, int low, int high, int mid, int[] temp) {
        //左边有序序列的初始索引
        int p1 = low;
        //右边有序序列的初始索引(为中间位置的后一个位置)
        int p2 = mid + 1;
        //指向temp数组的当前索引
        //此处index初始化必须为low,不能为0;因为merge()在mergeSort()中递归调用
        int index = low;

        // 移动p1、p2指针,先把左右两边的(已经有序)数据按排序规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完成为止
        while (p1 <= mid && p2 <= high) {
            if (arr[p1] < arr[p2]) {
                temp[index++] = arr[p1++];
            }else {
                temp[index++] = arr[p2++];
            }
        }
        //如有左右有一方没有走完(子序列没有全部放到temp)，那么顺序移动相应指针，将剩余元素放入temp
         while (p1 <= mid) {
             temp[index++] = arr[p1++];
         }

         while (p2 <= high) {
             temp[index++] = arr[p2++];
         }

        //将辅助数组中的有序序列放回到源数组
        for (int i = low; i <= high; i++){
            arr[i] = temp[i];
        }
    }
}


