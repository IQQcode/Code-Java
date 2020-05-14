package iqqcode.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-02 21:34
 * @Description:这题有点东西
 */
public class SolutionI {
    public static void main(String[] args) {
        int[] arr = new int[] {2,2,3,1};
        //System.out.println(findKth(arr,arr.length,3));
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        //去重,且有序
        //实例化一个set集合
        Set set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //返回Set集合的数组形式
        Object[] objs = set.toArray();
        int[] array = new int[objs.length];
        for (int i = 0; i < objs.length; i++) {
            int t = Integer.parseInt(String.valueOf(objs[i]));
            array[i] = t;
        }

        int K = 3;
        if(array.length == 1) {
            return array[0];
        }
        if(array.length == 2) {
            return (array[0] > array[array.length - 1]) ? array[0] : array[array.length - 1] ;
        }
        return quickSort(array,0,array.length-1,K);
    }

    private static int quickSort(int[] arr, int low, int high, int K) {
        int p = partion(arr, low, high); //中轴p
        if(K == p - low + 1) {
            return arr[p];
        }else if(p - low + 1 > K) {
            //递归左边
            return quickSort(arr,low,p - 1,K);
        }else {
            //递归右边
            return quickSort(arr,p + 1, high,K - ( p- low + 1));
        }
    }

    //找出中轴p
    private static int partion(int[] arr, int low, int high) {
        int tmp = arr[low];
        while(low < high){
            while(low < high && arr[high] <= tmp) {
                high--;
            }
            if(low == high) {
                break;
            }else{
                arr[low] = arr[high];
            }
            while(low < high && arr[low] >= tmp) {
                low++;
            }
            if(low == high) {
                break;
            }else {
                arr[high] = arr[low];
            }
        }
        arr[low] = tmp;
        return low;
    }
}
