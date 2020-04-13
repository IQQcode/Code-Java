package iqqcode.algorithm.sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 21:21
 * @Description:插入排序
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        //默认第一个元素有序
        for (int i = 1; i < arr.length; i++) {
            //待排序元素插入到已排序元素中
            for (int j = i; j > 0; j--) {
                //已排序元素与待排序的比较
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
