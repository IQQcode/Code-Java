package wanmeishijie;

import java.util.*;

public class Main {

    public static int search(int[] nums, int target) {
        //todo 实现算法
        int len = nums.length;
        int left = 0;
        int right = len  -1;
        while(left < right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if(nums[mid] > nums[right]) {
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] == target) {
                    right = mid;
                } else {
                    right--;
                }
            }
        }
        if(nums[left] == target) {
            return  left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int result = search(nums, target);
        System.out.println(result);
    }
}
