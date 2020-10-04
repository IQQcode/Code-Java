package duoyiwangluo;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: iqqcode
 * @Date: 2020-10-04 09:22
 * @Description:二倍均值法 [公式]
 * 剩余红包金额为M，剩余人数为N:  每次抢到的金额 = 随机区间 (0, M / N X 2)
 * <p>
 * [最后一次非公平] :
 * 除了最后一次，任何一次抢到的金额都要小于人均金额的两倍，并不是任意的随机。
 */
public class _02_RedPackage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入金额，分为单位, 扩大100倍
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
        int last_money = total;
        int last_people = amount;
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            //随机范围：[1，剩余人均金额的2倍 - 1] 分
            int randRedValue = random.nextInt(last_money / last_people * 2 - 1) + 1;
            redPackage[i] = randRedValue;
            last_money -= randRedValue;
            last_people--;
        }
        //最后一人分剩余金额, 此处为非公平
        redPackage[amount - 1] = last_money;
    }
}
