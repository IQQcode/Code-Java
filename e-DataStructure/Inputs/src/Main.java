import java.util.LinkedList;
import java.util.Queue;

public class Main<E extends Comparable<E>> {
    private TreeNode root;
    private int N;

    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return N;
    }

    public void add(E data) {
        root = add(root, data);
    }

    private TreeNode add(TreeNode root, E e) {
        if (root == null) {
            N++;
            return new TreeNode(e, null, null);
        }
        int compare = e.compareTo(root.data);
        if (compare > 0) root.right = add(root.right, e);
        if (compare < 0) root.left = add(root.left, e);
        //compare == 0 不做处理
        return root;
    }

    public boolean contains(E data) {
        return contains(root, data);
    }

    private boolean contains(TreeNode root, E data) {
        if (root == null) return false;
        int compare = data.compareTo(root.data);
        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return contains(root.left, data);
        } else {
            return contains(root.right, data);
        }
    }

    public E getMin() {
        if (root == null) {
            throw new IllegalArgumentException("root is null");
        }
        return getMin(root).data;
    }

    private TreeNode getMin(TreeNode node) {
        if (root.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    public E getMax() {
        if (root == null) {
            throw new IllegalArgumentException("root is null");
        }
        return getMax(root).data;
    }

    private TreeNode getMax(TreeNode node) {
        if (root.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    public E removeMin() {
        E min = getMin();
        root = removeMin(root);
        return min;
    }

    private TreeNode removeMin(TreeNode root) {
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;
            N--;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public E removeMax() {
        E max = getMax();
        root = removeMax(root);
        return max;
    }

    private TreeNode removeMax(TreeNode root) {
        if (root.right == null) {
            TreeNode leftNode = root.right;
            root.right = null;
            N--;
            return leftNode;
        }
        root.right = removeMax(root.right);
        return root;
    }

    public void remove(E data) {
        root = remove(root, data);
    }

    private TreeNode remove(TreeNode root, E data) {
        if (root == null) return root;
        int compare = data.compareTo(root.data);
        if (compare > 0) {
            root.right = remove(root.right, data);
        } else if (compare < 0) {
            root.left = remove(root.left, data);
        } else {
            // compare
            if (root.left != null) return root.right;
            if (root.right != null) return root.left;
            TreeNode minNode = root.right;
            while (minNode != null) {
                minNode = minNode.left;
            }
            root.data = minNode.data;
            root.right = remove(minNode, data);
            N--;
        }
        return root;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null) leftMax = maxDepth(root.left);
        if (root.right != null) rightMax = maxDepth(root.right);
        return leftMax > rightMax ? leftMax + 1 : rightMax + 1;
    }

    public int maxDepth_loop() {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        int levelSize = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (levelSize == 0) {
                height++;
                levelSize = queue.size();
            }
        }
        return height;
    }
}