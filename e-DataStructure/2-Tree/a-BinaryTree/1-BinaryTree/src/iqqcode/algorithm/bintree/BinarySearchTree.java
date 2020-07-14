package iqqcode.algorithm.bintree;

import java.util.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 12:44
 * @Description:二分搜索树--节点类无编号
 * @Time:使用二叉搜索树，添加、删除、搜索的最坏时间复杂度均可优化至：O(logn)
 */
public class BinarySearchTree<E extends Comparable<E>> {
    //记录根节点,默认root为null
    private Node root;
    //记录树中元素个数
    private int N;

    //内部节点类,直接存放数据
    private class Node {
        E data;
        Node left;   //左孩子
        Node right;  //右孩子
        Node parent; //父节点

        //初始化节点类
        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取树中元素个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 插入元素
     *
     * @param data
     */
    public void add(E data) {
        root = add(root, data);
    }

    private Node add(Node node, E e) {
        //插入的节点(node)为树的根节点(root)
        if (node == null) {
            N++;
            return new Node(e, null, null);
        }
        //以node为根节点的树不为空(插入的是孩子节点),比较node节点与插入节点值的大小
        int compare = e.compareTo(node.data);

        //如果e的值大于node节点，则继续递归向下找node节点的右子树
        if (compare > 0) node.right = add(node.right, e);

        //如果e的值小于node节点，则继续递归向下找node节点的左子树
        if (compare < 0) node.left = add(node.left, e);

        //由于定义的二分搜索树不保存重复元素, 所以针对node.e.compareTo(e) == 0的这种情况这里不做任何处理
        return node;
    }

    /**
     * 元素查找
     *
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
        } else if (compare < 0) {
            //如果data小于node节点，则继续递归向下找node节点的左子树
            return contains(node.left, data);
        } else {
            //如果data大于node节点，则继续递归向下找node节点的右子树
            return contains(node.right, data);
        }
    }

    /**
     * 查找树中的最小元素
     *
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
     *
     * @param node
     * @return
     */
    private Node getMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    /**
     * 查找树中的最大元素
     *
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
     *
     * @param node
     * @return
     */
    private Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 删除二分搜索树中的最小值
     *
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
     *
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
        //如果当前节点的右子树为空
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
     * @param e
     * @return 删除后的新树
     */
    public Node remove(Node node, E e) {
        //当前以node为根节点的树为空
        if (node == null) {
            return null;
        }
        //当前以node为根节点的树不为空,比较node节点与data的大小
        int compare = e.compareTo(node.data);

        if (compare > 0) {
            //如果e大于node节点，则继续递归向下找node节点的右子树
            node.right = remove(node.right, e);
        } else if (compare < 0) {
            //如果e小于node节点，则继续递归向下找node节点的左子树
            node.left = remove(node.left, e);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            //寻找右子树最小节点
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //将minNode的值赋给node
            node.data = minNode.data;
            //删除右子树中的最小的节点
            //最小节点断开连接
            //【此删除为值覆盖】让节点5的的data赋值给节点4的data, 断开节点5

            /**
             *      【4为待删除节点】
             *                       9
             *                    /     \
             *                   4        10
             *                /    \        \
             *              2       7 (n)    12
             *             /  \   /   \     /  \
             *            1   3  6     8   11  null
             *                  / \
             *                 5  null
             *               /
             *              null
             */
            //待删除节点的右子树的最小节点断开连接
            node.right = remove(node.right, minNode.data);
            N--;
        }
        return node;
    }

    /**
     * 获取整个树的最大深度
     *
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) return 0;
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

    /**
     * 获取整个树的最大深度--迭代(层序遍历有多少层)
     *
     * @return
     */
    public int maxDepth_loop() {
        return maxDepth(root);
    }

    //获取某个节点的高度
    private int maxDepth_loop(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //树的高度
        int height = 0;
        //下一层的节点数。即当前层的节点出队后，当前层节点的孩子节点数[queue.size](默认为1)
        int levelSize = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //TODO
            levelSize--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.left);
            }
            //当前层节点已访问完，即将访问下一层
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }


    //============================== <<前序遍历>> ===============================

    /**
     * @Link: https://blog.csdn.net/weixin_42322309/article/details/104177275
     */


    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历的递归方法, 深度优先
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //前序遍历先访问当前节点
        System.out.print(node.data + " ");
        //前序遍历访问左孩子
        preOrder(node.left);
        // 前序遍历访问右孩子
        preOrder(node.right);
    }


    /**
     * 前序遍历的非递归方法, 深度优先
     * 这里使用栈进行辅助实现
     * 前序遍历是指,先访问当前节点, 然后再访问左右子节点
     */
    public void preOrderNR() {
        // 使用栈辅助实现前序遍历
        Stack<Node> stack = new Stack<>();
        /*
         * 前序遍历的过程就是先访问当前节点, 然后再访问左子树, 然后右子树
         * 所以使用栈实现时, 可以先将当前节点入栈, 当前节点出栈时,
         * 分别将当前节点的右孩子, 左孩子压入栈
         */
        // 首先将根节点压入栈
        stack.push(root);
        while (!stack.isEmpty()) {

            Node node = stack.pop();

            // 前序遍历当前节点
            System.out.print(node.data + " ") ;

            // 由于栈是后入先出, 前序遍历是先左孩子, 再右孩子, 所以这里需要先将右孩子压入栈
            if (node.right != null)  stack.push(node.right);

            if (node.left != null)   stack.push(node.left);
        }
    }

    /********************************  <<中序遍历>>  ******************************/

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
        System.out.print(node.data + " ");
        // 前序遍历访问右孩子
        inOrder(node.right);
    }


    //中序遍历非递归
    public void inOrderNR() {
        if (root == null)   return;

        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            // 将当前节点的左子树全部入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    /********************************  <<后序遍历>>  ******************************/


    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历的递归方法
     *
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
        System.out.print(node.data + " ");
    }


    /**
     * @Topic:后续遍历非递归--双栈
     */
    public void postOrderNR_Stack() {
        if(root == null)    return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().data + " ");
        }
    }

    /**
     * @Topic:后续遍历非递归--指针
     */
    public void postOrderNR() {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node node = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            if (peek.left != null && peek.left != node && peek.right != node) {
                stack.push(peek.left);
                node = peek.left;
            } else if (peek.right != null && peek.right != node) {
                stack.push(peek.right);
                node = peek.right;
            } else {
                Node pop = stack.pop();
                System.out.print(pop.data + " ");
                node = pop;
            }
        }
    }



    /********************************  <<层序遍历>>  ******************************/


    /**
     * 层序遍历
     * 从上到下，自左向右遍历节点
     *
     * @return
     * @Solution:遍历过程 1.创建队列，存储每一层的结点；
     * 2.循环从队列中弹出一个结点：
     * - 获取当前结点
     * - 如果当前结点的左子结点不为空，则把左子结点放入到队列queue中
     * - 如果当前结点的右子结点不为空，则把右子结点放入到队列queue中
     * <p>
     * 遍历过程:
     * 1. 首先根节点入队
     * 2. 每次出队时, 都将当前节点的左右孩子先后入队
     * 3. 如果队列为空的话, 则表示层序遍历结束
     *                           5
     *                         /   \
     *                        3     6
     *                       / \     \
     *                      2  4      8
     * <p>
     * <p>
     *                   5-->
     *                   [<--5]   3-->  6-->   (3 , 6)
     *                   [<--3]   2-->  4-->   (2 , 4)
     *                   [<--6]   8-->         (2 , 4 , 8)
     *                   [<--2]   [<--4]   [<--8]
     * <p>
     * 针对上面的二分搜索树, 详细描述一下层序遍历步骤
     * 1. 5入队, 队列元素 : head->[5]<-tail
     * 2. 5出队, 5的左子树3, 6入队, 由于队列是先入先出(FIFO), 所以先左后右, 队列元素 : head->[3, 6]<-tail
     * 3. 3出队, 2, 4入队, 队列元素  : head->[6, 2, 4]<-tail
     * 4. 6出队, 左孩子为空,所以8入队, 队列元素  : head->[2, 4, 8]<-tail
     * 5. 2,4,8依次出队, 由于这三个节点都是叶子节点, 无子节点, 所以这三个节点出队后队列为空, 层序遍历完成
     */
    public void levelOrder() {
        if (root == null) return;

        // LinkedList实现了Queue接口
        Queue<Node> queue = new LinkedList<>();
        //默认，往队列中放入根节点
        queue.add(root);
        while (!queue.isEmpty()) {
            // 从队列中弹出一个结点，要将它下一层的孩子节点放入到队列中
            Node node = queue.poll();
            System.out.print(node.data + " ");
            // 判断当前结点还有没有左子结点，如果有，则放入到queue中
            if (node.left != null) {
                queue.add(node.left);
            }
            // 判断当前结点还有没有右子结点，如果有，则放入到queue中
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 层序遍历-递归
     */

    List<List<E>> list = new ArrayList<>();

    public void levelOrderRV() {
        levelRV(root, 0);
        System.out.println(list);
    }

    private void levelRV(Node root, int level) {
        if (root == null) return;

        //遍历到新的一层，创建list
        if(level >= list.size()) {
            list.add(new ArrayList());
        }
        //添加当前的元素
        list.get(level).add(root.data);
        //遍历左子节点
        levelRV(root.left, level + 1);
        //遍历右子节点
        levelRV(root.right, level + 1);
    }
}
