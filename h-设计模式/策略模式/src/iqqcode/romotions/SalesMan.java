package iqqcode.romotions;

/**
 * @Author: iqqcode
 * @Date: 2020-12-22 10:57
 * @Description:环境类-聚合策略类
 * @function:促销员
 */
public class SalesMan {
    // 聚合策略类
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // 出校源展示促销活动给用户
    public void salesManStrategy() {
        strategy.show();
    }
}
