package javaSE.TestDay06;

import java.util.*;

/**
 * 3 9 3 2 5 6 7 3 2 3 3 3
 *
 * ---> 3
 */

public class Test06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            System.out.println(majorityMap(arr));

            System.out.println(Bureau(arr));
        }
    }

    public static Map<Integer,Integer> majorityMap(int[] array) {

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        int result = -1;
        int N = array.length;
        int majorityCount = 0;

        for (int i = 0; i < N; ++i) {
            int temp = array[i];
            int count = 0;
            for (int j = 0; j < N; ++j) {
                if (array[j] == temp) {
                    count++;
                }
            }

            if (count > majorityCount) {
                majorityCount = count;
                result = temp;
                map.put(result, majorityCount);
            }
        }
        return map;
    }

    public static int Bureau(int[] arr) {
        int num = arr[0];
        int count = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] == num) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                num = arr[j];
            }
        }
        return num;
    }
}
