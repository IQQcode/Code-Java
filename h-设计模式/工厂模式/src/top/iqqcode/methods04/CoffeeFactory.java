package top.iqqcode.methods04;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:10
 * @Description:抽象工厂角色
 */
public interface CoffeeFactory {
    // 创建咖啡对象的方法
    Coffee creatCoffee();
}
