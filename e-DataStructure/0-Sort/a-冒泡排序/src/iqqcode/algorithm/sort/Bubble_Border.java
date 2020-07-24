package iqqcode.algorithm.sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-09 16:12
 * @Description:标志位该进版，针对一半有序一半无序
 * { 3, 4, 2, 1, 5, 6, 7, 8 }
 */
public class Bubble_Border {
    public static void bubble_Border(int[] arr) {
        for (int i = arr.length - 1; i > 0 ; i--) {
            // border之后的元素一定有序
            int border =  1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 把无序数列的边界更新为最后一次交换元素的位置
                    border = j + 1;
                }
            }
            i = border;
        }
    }
}
