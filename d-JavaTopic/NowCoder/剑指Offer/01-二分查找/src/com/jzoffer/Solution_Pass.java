package com.jzoffer;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-21 14:18
 * @Description:
 */
public class Solution_Pass {
    public static boolean find(int target, int [][] array) {
        if(array.length == 0 || array == null || array[0].length == 0) {
            return false;
        }
        //从右上角开始找，遇到比target小的，就去下一行，遇到比target大的，就到左边一列
        int row = 0;
        //列元素
        int col = array[0].length - 1;
        while(row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if(target >= array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(find(10,arr));
    }
}
