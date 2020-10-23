import java.util.Arrays;
import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-19 09:55
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = (left + right) >>> 1;
            if(target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //return arr[left] == target ? left : -1;
        System.out.println(left);
    }
}
