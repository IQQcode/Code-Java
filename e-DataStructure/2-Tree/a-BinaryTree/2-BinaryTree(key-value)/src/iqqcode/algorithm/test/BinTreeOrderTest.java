package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinTreeLinklist;
import org.junit.Test;
import java.util.Queue;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-16 16:23
 * @Description:遍历测试
 */
public class BinTreeOrderTest {
    @Test
    public void testPre() {
        //创建树对象
        BinTreeLinklist<Integer,String> tree = new BinTreeLinklist<>();
        //往树中添加数据
        tree.add(5, "E");
        tree.add(2, "B");
        tree.add(7, "G");
        tree.add(1, "A");
        tree.add(4, "D");
        tree.add(6, "F");
        tree.add(8, "H");
        tree.add(3, "C");

        System.out.println("查询测试--7号对应的值为：" + tree.contains(7));
        System.out.println("[前序遍历]");
        //遍历
        Queue<Integer> keys = tree.preOrder();
        for (Integer key : keys) {
            String value = tree.contains(key);
            System.out.println(key+"----"+value);
        }
    }

    @Test
    public void testIn() {
        //创建树对象
        BinTreeLinklist<Integer,String> tree = new BinTreeLinklist<>();
        //往树中添加数据
        tree.add(5, "E");
        tree.add(2, "B");
        tree.add(7, "G");
        tree.add(1, "A");
        tree.add(4, "D");
        tree.add(6, "F");
        tree.add(8, "H");
        tree.add(3, "C");

        System.out.println("查询测试--2号对应的值为：" + tree.contains(2));
        System.out.println("[中序遍历]");
        //遍历
        Queue<Integer> keys = tree.inOrder();
        for (Integer key : keys) {
            String value = tree.contains(key);
            System.out.println(key+"----"+value);
        }
    }

    @Test
    public void testPost() {
        //创建树对象
        BinTreeLinklist<Integer,String> tree = new BinTreeLinklist<>();
        //往树中添加数据
        tree.add(5, "E");
        tree.add(2, "B");
        tree.add(7, "G");
        tree.add(1, "A");
        tree.add(4, "D");
        tree.add(6, "F");
        tree.add(8, "H");
        tree.add(3, "C");

        System.out.println("查询测试--4号对应的值为：" + tree.contains(4));
        System.out.println("[后序遍历]");
        //遍历
        Queue<Integer> keys = tree.postOrder();
        for (Integer key : keys) {
            String value = tree.contains(key);
            System.out.println(key+"----"+value);
        }
    }

    @Test
    public void testLevel() {
        //创建树对象
        BinTreeLinklist<Integer,String> tree = new BinTreeLinklist<>();
        //往树中添加数据
        tree.add(5, "E");
        tree.add(2, "B");
        tree.add(7, "G");
        tree.add(1, "A");
        tree.add(4, "D");
        tree.add(6, "F");
        tree.add(8, "H");
        tree.add(3, "C");

        System.out.println("查询测试--8号对应的值为：" + tree.contains(8));
        System.out.println("[层序遍历]");
        //遍历
        Queue<Integer> keys = tree.levelOrder();
        for (Integer key : keys) {
            String value = tree.contains(key);
            System.out.println(key+"----"+value);
        }
    }

    @Test
    public void testDepth() {
        //创建树对象
        BinTreeLinklist<Integer,String> tree = new BinTreeLinklist<>();
        //往树中添加数据
        tree.add(5, "E");
        tree.add(2, "B");
        tree.add(7, "G");
        tree.add(1, "A");
        tree.add(4, "D");
        tree.add(6, "F");
        tree.add(8, "H");
        tree.add(3, "C");
        int maxDepth = tree.maxDepth();
        System.out.println("树的最大深度为: " + maxDepth);
    }

    @Test
    public void test1() {
        int i  = 0;
        for (int j = 0; j < 100; j++) {
            i = i++;
        }
        System.out.println(i);
    }
}
