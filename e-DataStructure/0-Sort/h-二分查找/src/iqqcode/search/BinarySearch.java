package iqqcode.search;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-20 09:46
 * @Description:基础二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid = 0;
        while (low <= high) {
            //mid = low + (high - low) / 2;
            mid = low + ((high-low) >> 1);
            if (key == arr[mid]) {
                return mid;
            }else if (key < arr[mid]) {
                high = mid - 1;
            }else  {
                low = mid + 1;
            }
        }
        return -1;
    }
}
