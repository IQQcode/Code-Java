package top.iqqcode.abstract05;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:45
 * @Description:抽象工厂类
 */
public interface DessertFactory {
    /**
     * 生产咖啡
     * @return
     */
    Coffee createCoffee();

    /**
     * 生产甜品
     * @return
     */
    Dessert createDessert();
}
