package iqqcode.algorithm.sort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-10 10:17
 * @Description:插入排序--方法
 * 1. void sort(Comparable[] a)：对数组内的元素进行排序
 * 2. boolean greater(Comparable v,Comparable w):判断v是否大于w
 * 3. void exch(Comparable[] a,int i,int j)：交换a数组中，索引i和索引j处的值
 */
public class InsertSortMethod {

    public static void insertSortMethod(Comparable[] arr) {
        //默认第一个元素有序
        for (int i = 1; i < arr.length; i++) {
            //待排序元素插入到已排序元素中
            for (int j = i; j > 0; j--) {
                //已排序元素与待排序的比较
                if(greater(arr[j-1], arr[j])) {
                    //交换元素
                    exch(arr, j-1, j);
                }else {
                    //找到了该元素，结束
                    break;
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
        return v.compareTo(w)>0;
    }

    /**
     *     数组元素i和j交换位置
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
