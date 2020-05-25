package iqqcode.search;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-20 16:50
 * @Description:查找第一个大于等于某个数 的下标
 */
public class GreaterOrEqual {
    public static int greaterOrEqual(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high-low) >> 1);
            if(key <= arr[mid]) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
