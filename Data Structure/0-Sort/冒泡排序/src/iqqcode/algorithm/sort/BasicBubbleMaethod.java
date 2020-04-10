package iqqcode.algorithm.sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-09 15:02
 * @Description:冒泡排序方法交换
 * 1.sort(Comparable[] a)：对数组内的元素进行排序
 * 2.greater(Comparable v,Comparable w):判断v是否大于w
 * 3.exch(Comparable[] a,int i,int j)：交换a数组中，索引i和索引j处的值
 */
public class BasicBubbleMaethod {
    /**
     * @自下往上冒泡
     * 由小到大排序
     * @param arr
     */
    public static void bubbleSort_CompareTo(Comparable[] arr) {
        int len = arr.length - 1;
        //参与冒泡的元素个数，即冒泡趟数
        for (int i = len; i > 0; i--) {
            //每趟冒泡次数
            for (int j = 0; j < i; j++) {
                if (greater(arr[j] , arr[j+1])){
                    exch(arr, j, j+1);
                }
            }
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
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
