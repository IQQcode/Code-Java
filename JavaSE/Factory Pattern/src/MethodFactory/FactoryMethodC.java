package MethodFactory;


//创建抽象工厂类，定义具体工厂的公共接口
abstract class Factory{
    public abstract Product Manufacture();
}

//抽象产品类
abstract class Product {
    public abstract void Show();
}

//具体产品类（继承抽象产品类）， 定义生产的具体产品；
class  ProductA extends  Product{
    @Override
    public void Show() {
        System.out.println("生产出了产品A");
    }
}

//具体产品B类
class  ProductB extends  Product{
    @Override
    public void Show() {
        System.out.println("生产出了产品B");
    }
}

//创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法
//工厂A类 - 生产A类产品
class  FactoryA extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

//工厂B类 - 生产B类产品
class  FactoryB extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}

//生产工作流程
public class FactoryMethodC {
    public static void main(String[] args){
        //客户要产品A
        FactoryA mFactoryA = new FactoryA();
        mFactoryA.Manufacture().Show();

        //客户要产品B
        FactoryB mFactoryB = new FactoryB();
        mFactoryB.Manufacture().Show();
    }
}
