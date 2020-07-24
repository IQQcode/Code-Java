package iqqcode.algorithm.bintree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-21 10:37
 * @Description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<>();
        return helper(1, n);
    }

    public static List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();

        if(start > end){
            // 如果当前子树为空，不加null行吗？
            list.add(null);
            return list;
        }

        for(int i = start; i <= end; i++){
            // 想想为什么这行不能放在这里，而放在下面？
            // TreeNode root = new TreeNode(i);
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);

            // 固定左孩子，遍历右孩子
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(generateTrees(3));
    }
}
