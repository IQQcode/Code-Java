package com.jzoffer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-03 17:06
 * @Description:深度优先搜索DFS
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 */
public class Solution {
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索 + 剪枝
     * @param board 待搜索矩阵
     * @param word 目标字符串
     * @param i 当前元素在矩阵board中的行列索引 i 和 j
     * @param j 当前元素在矩阵board中的行列索引 i 和 j
     * @param k 当前目标字符在word中的索引 k
     * @return
     */
    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 行或列索引越界 或 当前矩阵元素与目标字符不同 或 当前矩阵元素已访问过
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        // 字符串 word 已全部匹配
        if (k == word.length - 1) {
            return true;
        }
        //递推工作：
        //标记当前矩阵元素： 将board[i][j]值暂存于变量tmp ，并修改为字符 '/' ，代表此元素已访问过，防止之后搜索时重复访问
        char tmp = board[i][j];
        board[i][j] = '/';
        //搜索下一单元格： 朝当前元素的 下、上、右、左 四个方向开启下层递归，使用或接（代表只需一条可行路径），并记录结果至res
        boolean res = dfs(board, word, i + 1, j, k + 1 ) || dfs(board, word, i - 1, j, k + 1 ) ||
                dfs(board, word, i , j + 1, k + 1 ) || dfs(board, word, i, j - 1, k + 1 );
        /**
         * 还原当前矩阵元素： 将tmp暂存值还原至 board[i][j]元素
         * @board[i][j] = tmp---为什么要回溯？
         * 在DFS的过程中，由于每个单元个会被访问多次。在每次搜索中，会对board[i][j] = '/'做标记，代表当前已经访问过。
         * 只是要保证在当前匹配方案中不要走回头路(贪吃蛇咬自己尾巴)。
         * 但是不能影响下一次的搜索(如果不回溯则元素仍被标记为'/'),因为是一层一层向下递归来进行字符串匹配的，要取消本次搜索的标记，
         * 回溯的时候要“释放“这个单元格
         */
        board[i][j] = tmp;
        //回溯返回值： 返回 res ，代表是否搜索到目标字符串。
        return res;
    }
}
