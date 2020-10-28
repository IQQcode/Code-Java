package tencent_cloud;


import java.util.*;

public class Solution2 {

    private static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            if (temp.val <= pre)
                return false;
            pre = temp.val;
            if (temp.right != null) {
                TreeNode r = temp.right;
                while (r != null) {
                    stack.push(r);
                    r = r.left;
                }
            }
        }
        return true;
    }

    public static void addTreeNode(TreeNode node, String[] nodes) {
//        if (root == null) root = new TreeNode(data);
//
//        //采用随机方式创建二叉树
//        if (Math.random() > 0.5) {
//            if (node.left == null) {
//                node.left = new TreeNode(data);
//            } else {
//                addTreeNode(node.left, data);
//            }
//        } else {
//            if (node.right == null) {
//                node.right = new TreeNode(data);
//            } else {
//                addTreeNode(node.right, data);
//            }
//        }

    }

    public static void creat(int[] nodes) {
        List<TreeNode> datas = new ArrayList<>();
        //        将一个数组的值依次转换为Node节点
        for (int val : nodes) {
            datas.add(new TreeNode(val));
        }
//        第一个数为根节点
        root = datas.get(0);
//        建立二叉树
        for (int i = 0; i < nodes.length / 2; i++) {
//            左孩子
            datas.get(i).left = datas.get(i * 2 + 1);
//            右孩子
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }
    }


    public static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 8, 9, 11, 10, 6, 7, 3};
        creat(nodes);
        levelOrder(root);
    }
}
