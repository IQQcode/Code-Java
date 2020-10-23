package ThoughtWorks;

/**
 * @Author: iqqcode
 * @Date: 2020-10-23 22:18
 * @Description:
 */
public class SolutionTwo {

    public void skipTravel(int[][] map, int left, int right, int up, int down) {
        boolean leftToRight = true;
        while (true) {
            if (leftToRight) {
                moveL2R(map, left, right, up);
                leftToRight = false;
            } else {
                moveR2L(map, left, right, up);
                leftToRight = true;
            }
            // 边界判断
            if (up + 1 == down) {
                break;
            }
            // 跳跃条件
            if (up + 3 < down) {
                up = leftToRight ? skip(map, up, left, 3) : skip(map, up, right, 3);
            } else if (up + 3 == down) {
                up = leftToRight ? skip(map, up, left, 2) : skip(map, up, right, 2);
            } else {
                up = leftToRight ? skip(map, up, left, 1) : skip(map, up, right, 1);
            }
        }
    }

    private int skip(int[][] map, int up, int direction, int count) {
        for (int i = 0; i < count; i++) {
            map[up++][direction] = 1;
        }
        return up;
    }


    private void moveL2R(int[][] map, int left, int right, int up) {
        for (int col = left; col <= right; col++) {
            map[up][col] = 1;
        }
    }

    private void moveR2L(int[][] map, int left, int right, int up) {
        for (int col = right; col >= left; col--) {
            map[up][col] = 1;
        }
    }
}
