package sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-04 12:09
 * @Description:不稳定排序
 */
public class CountSort {
    public static int[] count(int[] arr) {
        // 得到数列的最大值和最小值，并算出差值
        int min = arr[0], max = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        int[] result = new int[arr.length];
        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }
        return result;
    }
}
