package iqqcode.algorithm.sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-10 09:33
 * @Description:选择排序--Method
 * 1. void sort(Comparable[] a)：对数组内的元素进行排序
 * 2. boolean greater(Comparable v,Comparable w):判断v是否大于w
 * 3. void exch(Comparable[] a,int i,int j)：交换a数组中，索引i和索引j处的值
 */
public class MergeSortMethod {

    public static void mergeSortMethod(Comparable[] arr) {
        //参与选择排序的元素：只剩一个元素时不用选择，到倒数第二个元素截止
        for (int i = 0; i < arr.length - 1; i++) {
            //假定本次遍历最小值所在的索引是i，默认第一个
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(greater(arr[minIndex] , arr[j])) {
                    //交换最小值所在的索引
                    minIndex = j;
                }
            }
            //将最小元素所在索引minIndex处的值与i索引的值交换
            exch(arr, i, minIndex);
        }
    }

    /**
     * 比较v元素是否大于w元素
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     *     数组元素i和j交换位置
     * @param arr
     * @param i
     * @param j
     */
    private static void exch(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
