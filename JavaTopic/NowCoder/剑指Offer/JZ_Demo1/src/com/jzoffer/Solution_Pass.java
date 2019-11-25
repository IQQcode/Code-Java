package com.jzoffer;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-21 14:18
 * @Description:
 */
public class Solution_Pass {
    public static boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length-1;   //列元素
        while(row <= array.length - 1) {
            if(target == array[row][col]) {
                return true;
            }else if(target >= array[row][col]) {
                row++;
            }else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Find(10,arr));
    }
}
