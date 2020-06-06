package iqqcode.algorithm.test;

import iqqcode.algorithm.list.DoublyLinkList;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-03 10:09
 * @Description:双向链表测试
 */
public class DoublyLinkListTest {
    @Test
    public void testLinkList() {
        //创建顺序表对象
        DoublyLinkList<String> dl = new DoublyLinkList<>();

        //测试插入
        dl.add("Java");
        dl.add("Python");
        dl.add("C++");
        //指定位置插入
        dl.add(1,"GoLang");
        dl.add(2,"PHP");

        for (Object o: dl) {
            System.out.println(o);
        }
        System.out.println("*****************************************************");

        //链表元素个数
        System.out.println("链表元素个数为： " + dl.length());

        //测试获取
        String s1 = dl.get(3);
        System.out.println("获取索引3处的元素： " + s1);

        //测试删除
        String s2  = dl.remove(2);
        System.out.println("删除索引2处的元素： " + s2);

        //测试首尾元素
        System.out.println("第一个元素是： " + dl.getFirst());
        System.out.println("最后一个元素是： " + dl.getLast());

        //测试清空
        dl.clear();
        System.out.println("清空顺序表，此时元素个数为： " + dl.length());
    }
}
