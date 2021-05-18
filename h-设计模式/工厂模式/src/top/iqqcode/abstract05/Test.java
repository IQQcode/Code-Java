package top.iqqcode.abstract05;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:51
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        // 创建对应风味的工厂
        DessertFactory factory = new ItalyDessertFactory();
        // 获取具体产品
        Coffee coffee = factory.createCoffee();  //拿铁
        Dessert dessert = factory.createDessert(); // 提拉米苏
        System.out.println(coffee.getName());
        dessert.show();
    }
}
