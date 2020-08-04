package test;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-12 15:04
 * @Description:
 */
public class InsertSort {
    public static void insertSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else {
                    break;
                }
            }
        }
    }
}
