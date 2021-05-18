package iqqcode.romotions;

/**
 * @Author: iqqcode
 * @Date: 2020-12-22 11:03
 * @Description:用户测试类
 */
public class Usre {
    public static void main(String[] args) {
        // 春节促销活动
        SalesMan salesMan = new SalesMan(new StrategyA());
        // 展示促销活动
        System.out.print("春节促销活动！");
        salesMan.salesManStrategy();


        // 中秋促销活动
        System.out.print("中秋促销活动！");
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManStrategy();


        // 元旦促销活动

        System.out.print("元旦促销活动！");
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManStrategy();
    }
}
