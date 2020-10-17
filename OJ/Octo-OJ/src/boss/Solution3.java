package boss;

/**
 * @Author: iqqcode
 * @Date: 2020-10-15 18:30
 * @Description:
 */

import java.util.*;

/**
 * [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
 * [5,1,10,9]
 */

public class Solution3 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param dataArr int整型一维数组
     * @return int整型一维数组
     */
    public static int[] calculateStatistics (int[] dataArr) {
        // write code here
        Arrays.sort(dataArr);
        int len = dataArr.length;
        int[] res = new int[4];
        int mid = (int) (Math.ceil(len / 2) - 1);
        res[0] = dataArr[mid];
        res[1] = dataArr[0];
        res[2] = dataArr[dataArr.length - 1];
        int TP = (int) (Math.ceil(len * 0.9) - 1);
        res[3] = dataArr[TP];
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(calculateStatistics(arr)));
    }
}
