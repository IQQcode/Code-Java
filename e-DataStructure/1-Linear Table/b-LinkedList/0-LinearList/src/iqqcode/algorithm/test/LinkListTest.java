package iqqcode.algorithm.test;

import iqqcode.algorithm.list.LinkList;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-03 10:09
 * @Description:单向链表测试
 */
public class LinkListTest {
    @Test
    public void testLinkList() {
        LinkList<String> sl = new LinkList<>();

        //测试插入
        sl.add("Java");
        sl.add("Python");
        sl.add("C++");
        //指定位置插入
        sl.add(2,"PHP");
        sl.add(1,"GoLang");
        //测试头插
        sl.insert("Rubby");

        for (Object o: sl) {
            System.out.println(o);
        }
        System.out.println("*****************************************************");

        //链表元素个数
        System.out.println("链表元素个数为： " + sl.length());

        //测试获取
        String s1 = sl.get(3);
        System.out.println("获取索引3处的元素： " + s1);

        //测试删除
        String s2  = sl.remove(2);
        System.out.println("删除索引2处的元素： " + s2);

        //测试清空
        sl.clear();
        System.out.println("清空链表，此时元素个数为： " + sl.length());
    }
}
