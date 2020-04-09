package iqqcode.algorithm.sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-09 16:12
 * @Description:标志位该进版，针对一半有序一半无序
 * { 3, 4, 2, 1, 5, 6, 7, 8 }
 */
public class OptimalBubblePlus {
    public static void optimalBubblePlus(int[] arr) {
        boolean flag = false;
        for (int i = arr.length - 1; i > 0 ; i--) {
            // sortBorder之后的元素一定有序
            int sortBorder = arr.length - 1;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 把无序数列的边界更新为最后一次交换元素的位置
                    sortBorder = j;
                    // 此趟排序没有进行数值交换
                    flag = true;
                }
            }
            // 在一趟排序中没有发生过交换
            if (!flag) {
                break;
            } else {
                // 重置flag,进行下次判断
                flag = false;
            }
        }
    }
}
