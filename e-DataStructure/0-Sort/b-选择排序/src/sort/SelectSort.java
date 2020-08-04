package sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 21:44
 * @Description:
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        //外层循环完成了数据交换，内层循环完成了数据比较

        //参与选择排序的元素：只剩一个元素时不用选择，到倒数第二个元素截止
        for (int i = 0; i < arr.length - 1; i++) {
            //假定本次遍历最小值所在的索引是i，默认第一个
            int minIndex = i;
            //让当前最小元素与它后面的元素依次进行比较
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    //交换最小值所在的索引
                    minIndex = j;
                }
            }
            //将最小元素所在索引minIndex处的值与i索引的值交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
