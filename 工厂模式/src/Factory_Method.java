
/**
 * 1.工厂方法模式
 * 第三方：一个具体工厂类
 * 解决：将客户段中的 new操作解耦到工厂类中；每当有新商品产生，无需修改客户端代码
 */

import java.util.Scanner;

interface  Computer {
    void creatComputer();
}

class Client {
    public void buyComputer(Computer computer) {
        computer.creatComputer();
    }
}

class iPad implements Computer {
    public void creatComputer() {
        System.out.println("买一个 MacBookPro...");
    }
}

class SurfaceBook implements Computer {
    public  void creatComputer() {
        System.out.println("买一个微软Surface!");
    }
}

class AlienWare implements Computer {
    public  void creatComputer() {
        System.out.println("买一个外星人");
    }
}










//************************************************************************************
/**
 * 工厂类
 * 简单工厂模式
 */

class ComputerFactory {
    //工具方法
    public  static Computer getInstance(String computerName) {
        if(computerName.equals("Mac")) {
        return new iPad();
    }else if(computerName.equals("Surface")) {
        return new SurfaceBook();
    }else if(computerName.equals("Alienware")) {
        return new AlienWare();
    }else {
            return null;
        }
    }
}


public class Factory_Method {
    //客户端
    public static void main(String[] args) {
        Client buy = new Client();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Computer type:");
        String computerName = input.nextLine();
        Computer computer = ComputerFactory.getInstance(computerName);
        buy.buyComputer(computer);
    }
}









//************************************************************************************

/**
 * 工厂方法模式
 * 抽象工厂接口
 */

//抽象工厂接口
/*
interface ComputerFactory {
    Computer produceComputer();
}

class AppleFactory implements ComputerFactory {
    @Override
    public Computer produceComputer() {
        return new MacBookPro();
    }
}

class Microsoft implements ComputerFactory {
    @Override
    public Computer produceComputer() {
        return new SurfaceBook();
    }
}


public class  Factory_Method {
    public static void main(String[] args) {
        Client buy = new Client();
         ComputerFactory factory = new AppleFactory();
        buy.buyComputer(factory.produceComputer());
    }
}*/
