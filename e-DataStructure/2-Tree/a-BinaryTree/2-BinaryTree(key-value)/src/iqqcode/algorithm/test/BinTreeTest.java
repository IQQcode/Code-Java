package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinTreeLinklist;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-16 15:19
 * @Description:增删改查测试
 */

public class BinTreeTest {
    @Test
    public  void testBinTreeLink() {
        BinTreeLinklist<Integer,String> tree = new BinTreeLinklist<>();

        tree.add(1 , "Java");
        tree.add(2 , "Python");
        tree.add(3 , "GoLang");
        tree.add(4 , "PHP");
        System.out.println("二叉树中元素个数为： " + tree.size());

        tree.add(4 , "JavaScript");
        System.out.println("key=4 对应的 value=" + tree.contains(4));

        tree.remove(3);
        System.out.println("删除后元素个数为： " + tree.size());
        System.out.println("删除后key=3处,value=" + tree.contains(3));
    }
}
