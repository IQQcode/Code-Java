package iqqcode.algorithm.bintree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 12:44
 * @Description:二分搜索树--节点类无编号
 */
public class BinarySearchTree<E extends Comparable<E>> {
    //记录根节点,默认root为null
    private Node root;
    //记录树中元素个数
    private int N;

    //内部节点类,直接存放数据
    private class Node {
        private E data;
        private Node left;  //左孩子
        private Node right;  //右孩子

        //初始化节点类
        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取树中元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 插入元素
     * @param data
     */
    public void add(E data) {
        root = add(root, data);
    }

    private Node add(Node node, E data) {
        //当前以node为根节点的树为空,插入的节点(node)作为数的根节点(root)
        if (node == null) {
            N++;
            return new Node(data, null, null);
        }
        //当前以node为根节点的树不为空,比较node节点与data的大小
        int compare = data.compareTo(node.data);
        if (compare > 0) {
            //如果data大于node节点，则继续递归向下找node节点的右子树
            node.right = add(node.right, data);
        }else if (compare < 0) {
            //如果data小于node节点，则继续递归向下找node节点的左子树
            node.left = add(node.left, data);
        }
        //由于定义的二分搜索树不保存重复元素, 所以针对node.e.compareTo(e) == 0的这种情况这里不做任何处理
        return node;
    }

    /**
     * 元素查找
     * @param data
     * @return
     */
    public boolean contains(E data) {
        return contains(root, data);
    }

    private boolean contains(Node node, E data) {
        //当前以node为根节点的树为空
        if (node == null) {
            return false;
        }
        //当前以node为根节点的树不为空
        //比较data和node节点的大小
        int compare = data.compareTo(node.data);
        if (compare == 0) {
            //如果key等于于node节点的键，找到了
            return true;
        }else if (compare < 0){
            //如果data小于node节点，则继续递归向下找node节点的左子树
            return contains(node.left, data);
        }else {
            //如果data大于node节点，则继续递归向下找node节点的右子树
            return contains(node.right, data);
        }
    }

    /**
     * 查找树中的最小元素
     * @return
     */
    public E getMin() {
        if (N == 0) {
            throw new IllegalArgumentException("BSTree is empty!");
        }
        return getMin(root).data;
    }

    /**
     * 查找以node为根节点的最小元素, 深度优先递归左子树
     * @param node
     * @return
     */
    private Node getMin(Node node){
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    /**
     * 查找树中的最大元素
     * @return
     */
    public E getMax() {
        if (N == 0) {
            throw new IllegalArgumentException("BSTree is empty!");
        }
        return getMax(root).data;
    }

    /**
     * 查找以node为根节点的最大元素, 深度优先递归右子树
     * @param node
     * @return
     */
    private Node getMax(Node node){
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 删除二分搜索树中的最小值
     * @return
     */
    public E removeMin() {
        //获取当前树中最小的节点(不一定为叶节点)
        E min = getMin();
        //让min的父亲节点指向min的右孩子节点
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {
        //如果当前节点的左子树为空
        if (node.left == null) {
            //将node节点的右子树与node节点的父节点连接，让node节点指向为空
            Node rightNode = node.right;
            node.right = null;
            N--;
            return rightNode;
        }
        //如果当前节点的左子树不为空，递归寻找叶子节点
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树中的最大值
     * @return
     */
    public E removeMax() {
        //获取当前树中最大的节点(不一定为叶节点)
        E max = getMax();
        //让max的父亲节点指向max的左孩子节点
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        //如果当前节点的左子树为空
        if (node.right == null) {
            //将node节点的左子树与node节点的父节点连接，让node节点指向为空
            Node leftNode = node.left;
            node.left = null;
            N--;
            return leftNode;
        }
        //如果当前节点的左子树不为空，递归寻找叶子节点
        node.right = removeMax(node.right);
        return node;
    }

    //删除树中任意节点
    public void remove(E data) {
        remove(root, data);
    }

    /**
     * 删除指定树中key对应的value，并返回删除后的新树
     *
     * @param node 给定需要添加元素的树的节点
     * @param data
     * @return 删除后的新树
     */
    public Node remove(Node node, E data) {
        //当前以node为根节点的树为空
        if (node == null) {
            return null;
        }
        //当前以node为根节点的树不为空,比较node节点与data的大小
        int compare = data.compareTo(node.data);
        if (compare > 0) {
            //如果data大于node节点，则继续递归向下找node节点的右子树
            node.right = remove(node.right, data);
        }else if (compare < 0) {
            //如果data小于node节点，则继续递归向下找node节点的左子树
            node.left = remove(node.left, data);
        }else {
            //如果key等于于node节点的键，则删除节点node

            //元素个数减一
            N--;

            //找到[要删除节点的]右子树中最小的节点(或者左子树中最大的节点)
            if (node.right == null) {
                //若要删除的节点的右子树为空，则直接返回其左子树
                return node.left;
            }

            if (node.left == null) {
                //若要删除的节点的左子树为空，则直接返回其右子树
                return node.right;
            }
            //寻找右子树最小节点
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //删除右子树中最小节点
            Node n = node.right;
            //最小节点断开连接
            while (n.left != null) {
                //某个节点的下一个节点的下一个节点为空，则断开连接
                if (n.left.left == null) {
                    node.left = null;
                }else {
                    //变换n节点
                    n = n.left;
                }
            }
            //让minNode节点补到原来待删除的node节点处
            minNode.left = node.left;
            minNode.right = node.right;
            minNode = node;
        }
        return node;
    }

    /**
     * 获取整个树的最大深度
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;
        // 左子树的最大深度
        int leftMax = 0;
        // 右子树的最大深度
        int rightMax = 0;
        // 计算node结点左子树的最大深度
        if (node.left != null) {
            leftMax = maxDepth(node.left);
        }
        // 计算node结点右子树的最大深度
        if (node.right != null) {
            rightMax = maxDepth(node.right);
        }
        // 比较左子树最大深度和右子树最大深度，取较大值+1即可
        return leftMax > rightMax ? leftMax + 1 : rightMax + 1;
    }



    //============================== 遍历 ===============================



    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历的递归方法, 深度优先
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //前序遍历先访问当前节点
        System.out.println(node.data);
        //前序遍历访问左孩子
        preOrder(node.left);
        // 前序遍历访问右孩子
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历的递归方法
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        //中序遍历先访问左孩子
        inOrder(node.left);
        //中序遍历再访问当前节点
        System.out.println(node.data);
        // 前序遍历访问右孩子
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历的递归方法
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        // 后序遍历先访问左孩子
        postOrder(node.left);
        // 后序遍历访问右孩子
        postOrder(node.right);
        //后序遍历再访问当前节点
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     * 从上到下，自左向右遍历节点
     * @Solution:遍历过程
     * 1.创建队列，存储每一层的结点；
     * 2.循环从队列中弹出一个结点：
     *      - 获取当前结点
     *      - 如果当前结点的左子结点不为空，则把左子结点放入到队列queue中
     *      - 如果当前结点的右子结点不为空，则把右子结点放入到队列queue中
     *
     * 遍历过程:
     * 1. 首先根节点入队
     * 2. 每次出队时, 都将当前节点的左右孩子先后入队
     * 3. 如果队列为空的话, 则表示层序遍历结束
     *       5
     *     /   \
     *    3     6
     *   / \     \
     *  2  4      8
     *
     *
     *    5-->
     *    [<--5]   3-->  6-->   (3 , 6)
     *    [<--3]   2-->  4-->   (2 , 4)
     *    [<--6]   8-->         (2 , 4 , 8)
     *   [<--2]   [<--4]   [<--8]
     *
     * 针对上面的二分搜索树, 详细描述一下层序遍历步骤
     * 1. 5入队, 队列元素 : head->[5]<-tail
     * 2. 5出队, 5的左子树3, 6入队, 由于队列是先入先出(FIFO), 所以先左后右, 队列元素 : head->[3, 6]<-tail
     * 3. 3出队, 2, 4入队, 队列元素  : head->[6, 2, 4]<-tail
     * 4. 6出队, 左孩子为空,所以8入队, 队列元素  : head->[2, 4, 8]<-tail
     * 5. 2,4,8依次出队, 由于这三个节点都是叶子节点, 无子节点, 所以这三个节点出队后队列为空, 层序遍历完成
     * @return
     */
    public void levelOrder() {
        // LinkedList实现了Queue接口
        Queue<Node> queue = new LinkedList<>();
        //默认，往队列中放入根节点
        queue.add(root);
        while (!queue.isEmpty()) {
            // 从队列中弹出一个结点
            Node n = queue.poll();
            // 判断当前结点还有没有左子结点，如果有，则放入到queue中
            if (n.left != null) {
                queue.add(n.left);
            }
            // 判断当前结点还有没有右子结点，如果有，则放入到queue中
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }
}
