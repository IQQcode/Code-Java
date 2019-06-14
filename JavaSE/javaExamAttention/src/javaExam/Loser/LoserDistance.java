package javaExam.Loser;

/**
 * 1.get,set方法混乱
 * 2.构造方法的初始化问题
 * 3.对象传值 MyPoint p
 */
class MyPoint {
    private double x,y;
    public MyPoint() {
        x = 0;
        y = 0;
    }
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double distance(MyPoint p) {
        return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y,2));
    }
    public double distance(double x,double y) {
        return Math.sqrt(Math.pow(x-this.x, 2)+Math.pow(y-this.y, 2));
    }
}
public class LoserDistance {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10,30.5);
        System.out.println(p1.distance(p2));
    }
}
