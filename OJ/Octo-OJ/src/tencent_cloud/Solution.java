package tencent_cloud;


import java.util.*;

public class Solution {

    private static TreeNode root;


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static LinkedList<Integer> isBST(TreeNode root, LinkedList<Integer> list) {
        if (root == null) return list;
        isBST(root.left, list);
        list.add(root.val);
        isBST(root.right, list);
        return list;
    }

    public static void add(int value) {
        root = add(root, value);
    }

    private static TreeNode add(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value, null, null);
        }
        int compare = (value - root.val);
        if (compare > 0) root.right = add(root.right, value);
        if (compare < 0) root.left = add(root.left, value);
        return root;
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        int[] arr = {9,4,10,2,5,8,7,6,1,3};
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println(isBST(root, list));
    }
}
