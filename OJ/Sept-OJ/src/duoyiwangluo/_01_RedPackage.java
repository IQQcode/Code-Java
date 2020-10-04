package duoyiwangluo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-03 16:44
 * @Description:[多益网络]
 *  实现抢红包算法, 10元5个红包, 保证红包的最小金额为1
 *
 *  [基础实现]：非公平, 剩余人的随机范围越来越小
 */
public class _01_RedPackage {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt() * 100;
        in.nextLine();
        int amount = in.nextInt();
        int[] redPackage = new int[amount];
        getRandomMoney(total, amount, redPackage);
        // 换做分输出
        for (int i = 0; i < amount; i++) {
            System.out.println("抢到金额" + new BigDecimal(redPackage[i]).divide(new BigDecimal(100)));
        }
    }

    public static void getRandomMoney(int total, int amount, int[] redPackage) {
        final int MIN_RED = 1;
        Arrays.fill(redPackage, MIN_RED);
        int last = total - amount;
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            //rand.nextInt(MAX - MIN + 1) + MIN
            int randRedValue = random.nextInt(last - 1);
            redPackage[i] += randRedValue;
            last -= randRedValue;
        }
        redPackage[amount - 1] += last;
    }

}
