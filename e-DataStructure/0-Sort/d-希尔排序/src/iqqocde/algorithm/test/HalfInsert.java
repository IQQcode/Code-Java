package iqqocde.algorithm.test;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-12 15:04
 * @Description:
 */
public class HalfInsert {
    public static void halfInsert(Integer[] arr) {
        int low, mid, high, j = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            low = 0;
            high = i - 1;
            while(low <= high) {
                mid = low + (high - low) / 2;
                if(temp > arr[mid]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            for (j = i - 1; j > high; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }
}
