package iqqcode.algorithm.sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-13 11:11
 * @Description:快速排序
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 左边界基准数
            int key = arr[low];
            int i = low;
            int j = high;
            while (i < j) {
                // j从右向左移动寻找，临界条件为 j == left，已经扫描到最左边了，无需继续扫描
                while (i < j && arr[j] > key) {
                    // 先从右向左找第一个小于key的数
                    j--;
                }
                // 将左右找到的元素进行交换
                if(i < j) {
                    arr[i++] = arr[j];
                }
                // i从左向右移动寻找，临界条件为 i == right，已经扫描到了最右边了，无需继续扫描
                while (i < j && arr[i] < key) {
                    // 再从左向右找第一个大于key的数
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            // 基准数归位
            arr[i] = key;
            //让左子组有序
            quickSort(arr, low, i - 1);
            //让右子组有序
            quickSort(arr, i + 1, high);
        }
    }
}
