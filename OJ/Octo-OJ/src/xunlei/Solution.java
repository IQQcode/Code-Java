package xunlei;

/**
 * @Author: iqqcode
 * @Date: 2020-10-19 18:52
 * @Description:迅雷笔试
 */

import java.util.*;

public class Solution {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[][] nodes = new String[4][2];
        Set<String> set = new HashSet<>();
        String a = null, b = null;
        for (int i = 0; i < n; i++) {
            a = nodes[i][0] = in.next();
            b = nodes[i][1] = in.next();
            set.add(a);
            set.add(b);
        }

        //拿到头结点
        for (int i = 0; i < nodes.length; i++) {
            if (set.contains(nodes[i][1])) {
                set.remove(nodes[i][1]);
            }
        }
        //获取集合的第一个元素
        String head = set.iterator().next();
        list.add(head);
        listRefactor(nodes, head);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void listRefactor(String[][] nodes, String head) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i][0].equals(head)) {
                list.add(nodes[i][1]);
                listRefactor(nodes, nodes[i][1]);
            }
        }
    }
}
