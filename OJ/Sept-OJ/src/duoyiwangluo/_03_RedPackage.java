package duoyiwangluo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-04 09:47
 * @Description:线段切割法 实现公平
 */
public class _03_RedPackage {
    //线段分割法
    private static List<Integer> getRandomMoney(int totalMoney, int amount) {
        //验证参数合理校验
        //为了使用random.nextInt(Integer)方法, 不得不先把红包金额放大100倍，最后在main函数里面再除以100
        //这样就可以保证每个人抢到的金额都可以精确到小数点后两位
        int redMoney = (int) (totalMoney * 100);
        if (redMoney < amount || redMoney < 1) {
            System.out.println("红包个数必须大于0，并且最小红包不少于1分");
        }
        List<Integer> boards = new ArrayList<>();
        boards.add(0);
        boards.add(redMoney);
        //红包个数和线段个数的关系
        while (boards.size() <= amount) {
            // 随机生成切割点
            int index = new Random().nextInt(redMoney - 1) + 1;
            if (boards.contains(index)) {
                //保证线段的位置不相同
                continue;
            }
            boards.add(index);
        }

        //计算每个红包的金额，将两个板子之间的钱加起来
        Collections.sort(boards);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < boards.size() - 1; i++) {
            Integer e = boards.get(i + 1) - boards.get(i);
            list.add(e);
        }
        return list;

    }

    public static void main(String[] args) {
        List<Integer> accountList = getRandomMoney(10, 5);
        BigDecimal count = new BigDecimal(0);
        for (Integer amount : accountList) {
            //将抢到的金额再除以100进行还原
            BigDecimal tmpcount = new BigDecimal(amount).divide(new BigDecimal(100));
            count = count.add(tmpcount);
            System.out.println("抢到金额：" + tmpcount);

        }
        System.out.println("total = " + count);
    }
}
