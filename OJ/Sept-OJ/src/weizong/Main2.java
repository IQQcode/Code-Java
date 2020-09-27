package weizong;

/**
 * @Author: iqqcode
 * @Date: 2020-09-27 18:54
 * @Description: 给你一个长度为n的序列A，你需要算出有多少个三元组(Ai,Aj,Ak)满足i<j<k且Ai≤Aj≤Ak
 * 6
 * 2 3 5 4 3 3
 * <p>
 * 6
 */

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        List list = new ArrayList();
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int[] ans = { arr[i], arr[j], arr[k]};
                    if(triplet(ans, ans.length)) {
                        count ++;
                    }
                    System.out.print(arr[i] + " " +arr[j]+ " " + arr[k]+ "\t");
                }
            }
        }
        System.out.println(list);
        System.out.println(count);
    }

    private static boolean triplet(int[] arr, int len) {
        if (len < 3) return false;
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i <= min) {
                min = i;
            } else if (i <= second) {
                second = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
