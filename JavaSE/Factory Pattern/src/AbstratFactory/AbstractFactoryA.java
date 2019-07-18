package AbstratFactory;

//抽象产品类CPU
interface CPU {
    void maker();
}

//具体制造CPU厂商 --->  海思麒麟
class Hisilicon implements CPU {

    @Override
    public void maker() {
        System.out.println("HUAWEI Hisilicon CPU produce maker..");
    }
}
//具体制造CPU厂商 --->  高通骁龙
class Snapdragon implements CPU {

    @Override
    public void maker() {
        System.out.println("Qualcomm Snapdragon CPU produce maker...");
    }
}


//抽象产品类 ARM
interface ARM {
    void maker();
}

//具体产品类 SAMSUNG_RAM

class SAMSUNG_RAM implements ARM {

    @Override
    public void maker() {
        System.out.println("SAMSUNG_RAM");
    }
}

//具体产品类 HUAWEI_RAM

class HUAWEI_RAM implements ARM {

    @Override
    public void maker() {
        System.out.println("HUAWEI_RAM");
    }
}

//抽象工厂类 PhonePartsFactory

interface PhonePartsFactory {
    CPU makingCPU();

    ARM produceARM();
}

//具体工厂制造商 HUAWEI P30 PhoneFactory
class HUAWEI_P30 implements PhonePartsFactory {

    @Override
    public CPU makingCPU() {
        System.out.println("HUAWEI SmartPhone CPU making!");
        return new Hisilicon();
    }

    @Override
    public ARM produceARM() {
        System.out.println("HUAWEI SmartPhone ARM producing!");
        return new HUAWEI_RAM();
    }
}


//具体工厂制造商 SAMSUNG Galaxy S10  PhoneFactory
class GalaxyS10 implements PhonePartsFactory {

    @Override
    public CPU makingCPU() {
        System.out.println("SAMSUNG SmartPhone CPU making!");
        return new Snapdragon();
    }

    @Override
    public ARM produceARM() {
        System.out.println("SAMSUNG SmartPhone ARM producing!");
        return new SAMSUNG_RAM();
    }
}


public class AbstractFactoryA {
    public static void main(String[] args) {
        PhonePartsFactory phoneA = new HUAWEI_P30();
        PhonePartsFactory phoneB = new GalaxyS10();
        CPU cpuA = phoneA.makingCPU();
        ARM armA = phoneA.produceARM();
        cpuA.maker();
        armA.maker();
        System.out.println("\n-----------------------------------\n");
        CPU cpuB = phoneB.makingCPU();
        ARM armB = phoneB.produceARM();
        cpuB.maker();
        armB.maker();
    }
}
