package qihu360;

/**
 * @Author: iqqcode
 * @Date: 2020-09-26 17:56
 * @Description: 一只乌龟来到了图论森林游玩。图论森林可以被抽象地看作有n个点m条带权无向边的简单图，没有自环没有重边。
 * 乌龟需要从s点到达t点。森林里居住了很多兔子，乌龟在经过一条边时会因为爬得太慢而受到边上兔子们的嘲笑，
 * 一条边上兔子数量为这条边的边权。乌龟想承受尽可能少的嘲笑，它想找到一条从起点到终点的路径，路径上有一条边的兔子是这条路径所有边中最多的，
 * 它想让这个值尽可能少，请问最少是多少。
 * <p>
 * 第一行四个数n,m,s,t。
 * <p>
 * 接下来m行，每行三个数u,v,w，表示u和v之间有一条边权为w的无向边。
 * <p>
 * 输入保证s点和t点连通。
 * <p>
 * 1≤n≤100,000；0≤m≤200,000；1≤w≤1,000,000,000
 * <p>
 * 5 6 1 5
 * 1 5 100
 * 1 2 10
 * 2 5 5
 * 1 3 3
 * 3 4 2
 * 4 5 1
 * <p>
 * --> 3
 */

import java.util.*;

public class Solution2 {

    private static class Edge implements Comparable {
        int val;
        int a;
        int b;

        public Edge(int a, int b, int val) {
            this.val = val;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(val, ((Edge) o).val);
        }
    }


    public static int tree_shot(int point, int side, int start, int end, int[][] map) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
//        for (int i = 0; i <= point; i++) {
//            queue.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
//        }
        while(!queue.isEmpty()) {
            Edge cur = queue.poll();
            int a = cur.a;
            int b = cur.b;

        }
        return 3;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int point = in.nextInt();
        int side = in.nextInt();
        int start = in.nextInt();
        int end = in.nextInt();
        int[][] map = new int[side][3];
        int p1 = 0, p2 = 0, value = 0;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = in.nextInt();
            }
        }
        System.out.println(tree_shot(point, side, start, end, map));
    }
}
