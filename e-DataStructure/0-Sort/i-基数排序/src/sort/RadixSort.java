package sort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-04 14:25
 * @Description:基数排序--基于计数排序
 */
public class RadixSort {
    public static int[] radixSort(int[] arr) {
        int max_num = getMax(arr);
        for (int division = 1; max_num / division > 0; division *= 10) {
            countSort(arr, division);
        }
        return arr;
    }

    //得到数列的最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    //得到数列的最小值
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static void countSort(int[] arr, int division) {
        //排序结果数组，用于存储每一次按位排序的临时结果
        int[] result = new int[arr.length];
        int[] count = new int[getMax(arr) - getMin(arr) + 1];

        //从个位开始比较，一直比较到最高位
        //获取每一位数进行比较，个位.十位..百位...
        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / division) % 10;
            count[digit]++;
        }

        // 2.统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 3.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = (arr[i] / division) % 10;
            result[--count[num]] = arr[i];
        }
        //下一轮排序需要以上一轮的排序结果为基础，因此把结果复制给arr
        System.arraycopy(result, 0, arr, 0, arr.length);
        Arrays.fill(count, 0);
    }
}