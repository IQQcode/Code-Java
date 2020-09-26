package qihu360;

/**
 * @Author: iqqcode
 * @Date: 2020-09-26 21:22
 * @Description:
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            List<Line> lineset = new ArrayList<Line>();
            for (int i = 0; i < m; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int weight = sc.nextInt();
                Line line = new Line(start, end, weight);
                lineset.add(line);
            }
            System.out.println(minLaugh(lineset, n, s, t));
        }
    }

    public static int minLaugh(List<Line> lineset, int n, int s, int t) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(s, 0);
        PriorityQueue<Line> linequeue = new PriorityQueue<Line>(new Comparator<Line>() {

            @Override
            public int compare(Line o1, Line o2) {
                return o1.weight - o2.weight;
            }
        });
        int newpoint = s;
        while (!(map.containsKey(t) || map.size() == n)) {
            for (int i = 0; i < lineset.size(); i++) {
                Line line = lineset.get(i);
                if (line.start == newpoint || line.end == newpoint) {
                    linequeue.add(new Line(line));
                    lineset.remove(i);
                    i--;
                }
            }
            Line newline = linequeue.poll();
            if (map.containsKey(newline.start) && !map.containsKey(newline.end)) {
                map.put(newline.end, Math.max(map.get(newline.start), newline.weight));
                newpoint = newline.end;
            } else if (!map.containsKey(newline.start) && map.containsKey(newline.end)) {
                map.put(newline.start, Math.max(map.get(newline.end), newline.weight));
                newpoint = newline.start;
            } else {
                continue;
            }
        }
        return map.get(t);
    }

    static class Line {
        int start;
        int end;
        int weight;

        public Line(Line line) {
            this.weight = line.weight;
            this.start = line.start;
            this.end = line.end;
        }

        public Line(int start, int end, int weight) {
            this.weight = weight;
            this.start = Math.min(start, end);
            this.end = Math.max(start, end);
        }
    }
}
