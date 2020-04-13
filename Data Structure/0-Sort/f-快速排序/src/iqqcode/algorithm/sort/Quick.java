package iqqcode.algorithm.sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-13 11:11
 * @Description:快速排序
 */
public class Quick {
    public static void quick(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
        //返回的是分组的分界值所在的索引，分界值位置变换后的索引
        int partition = partition(arr, low, high);
        //递归调用让左子组有序
        quick(arr, low,partition - 1);
        //让右子组有序
        quick(arr, partition + 1, high);
    }

    /**
     * 对数组a中，从索引low到索引high之间的元素进行分组，并返回分组界限对应的索引
     */
    public static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        int i = low; //左指针
        int j = high; //右指针
        while (i < j) {
            // j从右向左移动寻找，临界条件为 j == left，已经扫描到最左边了，无需继续扫描
            while (i < j && arr[j] > key) {
                // 先从右向左找第一个小于key的数
                j--;
            }
            // i从左向右移动寻找，临界条件为 i == right，已经扫描到了最右边了，无需继续扫描
            while (i < j && arr[i] < key) {
                // 再从左向右找第一个大于key的数
                i++;
            }
            //交换 i和 j指针所指向的元素
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //key和指针重合点交换
        arr[low] = arr[i];
        arr[i] = key;
        return i;
    }
}
