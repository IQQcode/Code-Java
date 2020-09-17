package sept14.baidu;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-14 23:30
 * @Description: 百度笔试题二
 * leetcode-130
 * <p>
 * 【输入问题】: 字符串输入二维数组，转为int[] 数组
 */
public class SolutionII {

    /**
     * 1111
     * 0101
     * 1101
     * 0010
     * <p>
     * <p>
     * 1111
     * 0111
     * 1111
     * 0010
     */

    public static void check(int[][] chess) {
        if (chess == null || chess.length == 0) return;
        int n = chess.length;
        int m = chess[0].length;
        for (int i = 0; i < n; i++) {
            //将外围的0先标记为中间状态 '2'
            //第一行， 最后一行
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < m; j++) {
                    fill(i, j, chess, n, m);
                }
            }
            //第一列
            fill(i, 0, chess, n, m);
            //最后一列
            fill(i, m - 1, chess, n, m);
        }

        //填充被包围的，还原边界临时值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //先覆盖0, 再还原2.否则还原的2会被新覆盖
                if (chess[i][j] == 0) chess[i][j] = 1;
                if (chess[i][j] == 2) chess[i][j] = 0;
            }
        }
    }

    private static void fill(int i, int j, int[][] chess, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || chess[i][j] == 2 || chess[i][j] == 1)
            return;
        //将边界的 0 暂时变为 2
        chess[i][j] = 2;
        fill(i - 1, j, chess, n, m); //上
        fill(i, j + 1, chess, n, m); //右
        fill(i + 1, j, chess, n, m); //下
        fill(i, j - 1, chess, n, m); //左
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int side = in.nextInt();
        String[] ss = new String[side];
        for (int i = 0; i < side; i++) {
            ss[i] = in.next();
        }
        int[][] chess = new int[side][side];
        String temp = null;
        for (int i = 0; i < side; i++) {
            temp = ss[i];
            for (int j = 0; j < side; j++) {
                chess[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }
        check(chess);

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
    }
}
