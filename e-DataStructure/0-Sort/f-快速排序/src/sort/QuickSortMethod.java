package sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-13 18:28
 * @Description:基准数方法独立
 */
public class QuickSortMethod {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSortMethod(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
        //返回的是分组的分界值所在的索引，分界值位置变换后的索引
        int pivot = partition(arr, low, high);
        //递归调用让左子组有序
        quickSortMethod(arr, low,pivot - 1);
        //让右子组有序
        quickSortMethod(arr, pivot + 1, high);
    }

    //对数组a中，从索引 lo到索引 hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(int[] arr, int low, int high) {
        // 左边界基准数
        int key = arr[low];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int i = low;
        int j = high + 1;
        while (i < j) {
            // 先从右向左找第一个小于key的数
            while(arr[--j] > key) { //循环停止，证明找到了一个比基准值小的元素
                if (j == low) {
                    break; //已经扫描到最左边了，无需继续扫描
                }
            }
            // 先从右向左找第一个小于key的数
            while (arr[++i] < key) { //循环停止，证明找到了一个比基准值大的元素
                if (i == high) {
                    break; //已经扫描到了最右边了，无需继续扫描
                }
            }
            if (i < j) {
                //交换 i和 j索引处的元素
                swap(arr, i, j);
            }
        }
        //分界值与 i或 j交换
        swap(arr, low, j);
        return j;
    }
}

