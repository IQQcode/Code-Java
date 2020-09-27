package weizong;

/**
 * @Author: iqqcode
 * @Date: 2020-09-27 18:54
 * @Description: 第一行两个整数n, q分别表示数组的长度和查询的次数。(1≤n，q≤1e5)
 * <p>
 * 第二行n个数分别表示a1, a2, a3, … an。(0≤ai≤1e8)
 * <p>
 * 接下来q行每行一个数x表示需要查询的数。(0≤x≤1e8)
 * 5 5
 * 1 2 3 4 5
 * 3
 * 0
 * 7
 * 2
 * 5
 * <p>
 * 3
 * 1
 * 5
 * 2
 * 5
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int selected = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        while (in.hasNext()) {
            int target = in.nextInt();
            in.nextLine();
            System.out.println(query(arr, target));
        }
    }

    private static int query(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = 0;
        for (right = arr.length - 1; left != right; ) {
            int midIndex = (left + right) >>> 1;
            int mid = (right - left);
            int res = arr[midIndex];
            if (res == target) {
                return midIndex;
            }
            if (target > res) {
                left = midIndex;
            } else {
                right = midIndex;
            }
            if (mid <= 2) break;
        }
        int ans = Math.abs((arr[right] - arr[left]) / 2 + 1) > Math.abs(arr[right] - target) ? arr[right] : arr[left];

        return ans;
    }
}
