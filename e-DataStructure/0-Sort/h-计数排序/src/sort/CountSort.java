package sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-04 12:09
 * @Description:不稳定排序 数据量很大，但是数据范围小
 */
public class CountSort {
    public static int[] count(int[] arr) {
        // 得到数列的最大值和最小值
        int min = arr[0], max = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)  max = arr[i];
            if (arr[i] < min)  min = arr[i];
        }

        //并算出差值, max-min 减少空间损失
        int range = max - min + 1; //10 个数， 9 - 0 + 1 = 10
        //临时数组用于记录arr[i++]出现的次数
        int[] count = new int[range];
        for (int i = 0; i < arr.length; i++) {
            //减min 使数组下标与arr[i++]对应
            //++: 每出现一次加一
            //元素原来的顺序不变，稳定
            count[arr[i] - min]++;
        }

        //还原数组
        int[] result = new int[arr.length];
        for (int i = 0, j = 0; i < count.length; i++) {
            //count[i]代表出现次数
            while (count[i]-- > 0) {
                //还原
                result[j++] = i + min;
            }
        }
        return result;
    }
}
