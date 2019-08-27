package sort.Bubble;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-25 09:28
 * @Description:基础冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
       int[] array = new int [] {0, 20, 1, 80, 3, 2};
       bubbleSort(array,array.length);
        System.out.println("The Bubble Sort is : ");
       for(int i : array) {
           System.out.print(i + " ");
       }
    }
    public static void bubbleSort(int[] arr,int len) {
        for(int i = len-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr [j] > arr [j + 1]) {
                    int temp = arr [j];
                    arr [j] = arr [j+1];
                    arr [j+1] = temp;
                }
            }
        }
    }
}
