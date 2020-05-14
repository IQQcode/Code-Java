package MethodFactory;

/**
 * 产品类：
 */

//抽象产品类Computer
interface Computer {
    void buyComputer();
}

//具体产品类 iPaid
class iPaid implements Computer {
    @Override
    public void buyComputer() {
        System.out.println("买一台iPaid...");
    }
}

//具体产品类 Surface
class Surface implements Computer {
    @Override
    public void buyComputer() {
        System.out.println("买一台微软Surface...");
    }
}

/**
 * 创建工厂类
 */
interface ComputerFactory {
    Computer createComputer();
}

//具体产品的工厂类 iPaidFactory
class iPaidFactory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        System.out.println("生产一台iPaid!");
        return new iPaid();
    }
}

//具体产品的工厂类 SurfaceFactory
class SurfaceFectory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        System.out.println("生产一台Microsoft Surface!");
        return new Surface();
    }
}

//客户端 FactoryMethod
public class FactoryMethodA {
    public static void main(String[] args) {
        Computer AppleIpaid,MicrosoftSurface;
        ComputerFactory iPaidFactory = new iPaidFactory();
        ComputerFactory SurfaceFactory = new SurfaceFectory();
        AppleIpaid = iPaidFactory.createComputer();
        MicrosoftSurface = SurfaceFactory.createComputer();
    }
}
