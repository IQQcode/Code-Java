package xiecheng;

/**
 * @Author: iqqcode
 * @Date: 2020-10-13 09:00
 * @Description:携程笔试
 */

import java.lang.reflect.Array;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[][] costs = new int[4][2];
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            costs[i][0] = incomeOfA;
            costs[i][1] = incomeOfB;
            i++;
        }
        System.out.println(twoCity(costs));

        //Start coding
    }

    /**
     * 10 30
     * 100 200
     * 150 50
     * 60 20
     * #
     */
    private static int twoCity(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o2[1] -(o1[0] - o1[1]);
            }
        });
        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
}
/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 正值下班高峰时期，现有可载客司机数2N人，调度中心将调度相关司机服务A、B两个出行高峰区域。
 *
 * 第 i 个司机前往服务A区域可得收入为 income[i][0]，前往服务B区域可得收入为 income[i][1]。
 *
 * 返回将每位司机调度完成服务后，所有司机总可得的最高收入金额，要求每个区域都有 N 位司机服务。
 *
 *
 *
 * 输入描述
 * 10 20
 *
 * 20 40
 *
 * #
 *
 * 如上：
 *
 * 第一个司机服务 A 区域，收入为 10元
 *
 * 第一个司机服务 B 区域，收入为 20元
 *
 *
 * 第二个司机服务 A 区域，收入为 20元
 *
 * 第二个司机服务 B 区域，收入为 40元
 *
 * 输入参数以 '#' 结束输入
 *
 * 输出描述
 * 最高总收入为 10 + 40= 50，每个区域都有一半司机服务
 *
 * 参数及相关数据异常请输出：error
 *
 *
 * 样例输入
 * 10 30
 * 100 200
 * 150 50
 * 60 20
 * #
 * 样例输出
 * 440
 *
 * 提示
 * 最优策略
 * 1 <= income.length <= 100
 * income.length 为偶数
 * 1 <= income[i][0], income[i][1] <= 1000
 * 规则
 * **/
