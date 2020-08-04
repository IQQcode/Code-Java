package sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-17 10:23
 * @Description:折半插入排序
 */
public class HalfInsert {
    public static void halfInsert(int[] arr) {
        int low , mid, high, j = 0;
        for (int i = 1;i < arr.length; i++) {
            //未排序集合的第 一个元素
            int temp = arr[i];
            //已排序集合的第一个元素
            low = 0;
            //已排序集合的最后一个元素
            high = i - 1;
            while (low <= high) {
                //已排序集合中间元素
                mid = low + (high - low) / 2;
                if (temp > arr[mid]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            //要插入的位置在high+1，搬移元素
            for (j = i - 1; j > high; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }
}
