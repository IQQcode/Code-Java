package MethodFactory;

//产品类：
interface BMW {
    void buyBMW();
}

class BMW320 implements BMW {

    @Override
    public void buyBMW() {
        System.out.println("制造-->BMW320");

    }
}

class BMW523 implements BMW {

    @Override
    public void buyBMW() {
        System.out.println("制造-->BMW523");

    }
}

//创建工厂类：
interface FactoryBMW {
    BMW createBMW();
}

class FactoryBMW320 implements FactoryBMW{

    @Override
    public BMW320 createBMW() {

        return new BMW320();
    }

}
class FactoryBMW523 implements FactoryBMW {
    @Override
    public BMW523 createBMW() {

        return new BMW523();
    }
}

//客户端
public class FactoryMethodB {
    public static void main(String[] args) {
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createBMW().buyBMW();

        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createBMW().buyBMW();
    }
}
