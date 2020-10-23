package ThoughtWorks;

/**
 * @Author: iqqcode
 * @Date: 2020-10-23 22:11
 * @Description:
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();

        // 创建地图
        int[][] map = createMap(row, col);
        // 螺旋飞行
        //new SolutionOne().spiralTravel(map, 0, map[0].length - 1, 0, map.length - 1);

        // 跳跃飞行
        new SolutionTwo().skipTravel(map, 0, map[0].length - 1, 1, map.length - 1);
        // 打印结果
        printMap(map);
    }

    public static int[][] createMap(int row, int col) {
        return new int[row][col];
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

