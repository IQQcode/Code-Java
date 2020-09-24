package wanmeishijie;


import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }

        //获取天际线，待实现
        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        //todo 实现算法
        List<List<Integer>> points = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = buildings.length;
        //求出左上角 和右上角坐标， 左上角 y为负数
        for (int[] arr : buildings) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(arr[0]);
            l1.add(-arr[2]);
            points.add(l1);

            List<Integer> l2 = new ArrayList<>();
            l2.add(arr[1]);
            l2.add(arr[2]);
            points.add(l2);
        }
        //所有坐标排序
        Collections.sort(points, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int x1 = o1.get(0);
                int y1 = o1.get(1);
                int x2 = o2.get(0);
                int y2 = o2.get(1);
                if (x1 != x2) {
                    return x1 - x2;
                } else {
                    return y1 - y2;
                }
            }
        });

        //实现大顶堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        queue.offer(0);
        int ansMax = 0;
        for (List<Integer> list : points) {
            int x = list.get(0);
            int y = list.get(1);
            //左上角坐标
            if (y < 0) {
                queue.offer(-y);
            } else {
                queue.remove(y);
            }

            int curMax = queue.peek();
            if (curMax != ansMax) {
                List<Integer> ans = new ArrayList<>();
                ans.add(x);
                ans.add(curMax);
                res.add(ans);
                ansMax = curMax;
            }
        }
        return res;
    }
}
