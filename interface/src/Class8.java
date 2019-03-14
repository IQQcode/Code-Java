/**
 * 一、interface定义
 *I.子类实现接口使用"implement"关键字,同时实现多个接口继承<类继承多个接口>;
 *       ---一个接口可以使用"extends"继承多个父接口<接口普继承多个接口>;
 * II.子类必须覆写所有的抽象方法，子类命名使用impl结尾;
 * III.多个接口若有共同子类，可以通过子类进行相互转化<父接口间的相互转换>
 */

/*
interface IMessage {
    public static final String MSG = "Don't lose heart,come on!";

    public abstract void print();
}

interface IFun {
    public abstract String judge();
}

class MessageImpl implements IMessage,IFun {
    */
/**
     * 抽象类必须覆写父类的所有方法
     *//*

    public void print() {
        System.out.println(MSG);
    }

    public String judge() {
        return IMessage.MSG;
    }
}
public class Class8 {
    public static void main(String[] args) {

        //抽象类要实例化子类，发生向上转型
        IMessage msg = new MessageImpl();
        msg.print();
        */
/**
         * 只能使用接口中定义的 IMessage方法，IFun asm = new MessageImpl();
         *//*

        IFun acm = (IFun) msg;
        //通过共同的子类MessageImpl强转,等同于 IFun acm = new MessageImpl();
        System.out.println(acm.judge());
    }
}
*/


/**
 * 二、interface的使用
 * 1.当子类既需要实现接口又需要继承抽象类时：
 *           先"extends"一个接口，而后"implements"多个接口;
 *                    当父类与父接口有相同子类时，父类和父接口可以通过子类相互转换
 *                   ---class MessageImpl extends News implements IMessage { }
 *
 * 2.抽象类可以使用 implements实现若干个接口，而接口无法继承抽象类
 *
 * 3.接口之间可以使用 extends继承多个接口
 */

/*
interface A {
    void playA();
}
interface B {
    void playB();
}
interface  C extends  A,B {
    void  playC();
}

abstract  class CImpl implements C {}

class Test extends CImpl {
    @Override
    public void playA() { }

    @Override
    public void playB() { }

    @Override
    public void playC() { }
}

public class Class8 {
    public static void main(String[] args) {
        C c = new Test();
        c.playC();
    }
}
*/




