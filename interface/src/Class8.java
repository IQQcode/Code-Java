/**
 * 一、interface定义
 *I.子类实现接口使用"implement"关键字,同时实现多个接口继承<类继承多个接口>;
 *       ---一个接口可以使用"extends"继承多个父接口<接口普继承多个接口>;
 * II.子类必须覆写所有的抽象方法，子类命名使用impl结尾;
 * III.多个接口若有共同子类，可以通过子类进行相互转化<父接口间的相互转换>
 */

interface IMessage {
    public static final String MSG = "Don't lose heart,come on!";

    public abstract void print();
}

interface IFun {
    public abstract String judge();
}

class MessageImpl implements IMessage,IFun {
    /**
     * 抽象类必须覆写父类的所有方法
     */
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
        /**
         * 只能使用接口中定义的 IMessage方法，IFun asm = new MessageImpl();
         */
        IFun acm = (IFun) msg;
        //通过共同的子类MessageImpl强转,等同于 IFun acm = new MessageImpl();
        System.out.println(acm.judge());
    }
}


/**
 * 二、interface的使用
 * 1.先"extends"一个接口，在"implements"多个接口;
 *                   ---class MessageImpl extends News implements IMessage { }
 */

