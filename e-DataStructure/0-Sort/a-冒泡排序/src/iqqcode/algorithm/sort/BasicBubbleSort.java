package iqqcode.algorithm.sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-09 15:02
 * @Description:基础冒泡排序
 */
public class BasicBubbleSort {
    /**
     * @自下往上冒泡
     * 由小到大排序
     * @param arr
     */
    public static void bubbleSort_toLarge(int[] arr) {
        int len = arr.length - 1;
        //参与冒泡的元素个数，即冒泡趟数
        for (int i = len; i > 0; i--) {
            //每趟冒泡次数
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    /**
     * @自上往下冒泡
     * 由大到小排序
     * @param arr
     */
    public static void bubbleSort_toSmall(int[] arr) {
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if(arr[j] < arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
