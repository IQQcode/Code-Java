package javaExam.Loser;
import java.util.*;

/**
 * 1. super访问父类构造方法
 * 2. 对象数组
 */
interface Colorable {
    void howToColor();
}

abstract class GeometricObject implements Colorable {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }
    public GeometricObject(String color,boolean filled) {
        super();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean getFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "\nCreated on: " + dateCreated + "\ncolor: " + color + "\nfilled: " + filled;
    }
}

class Square extends GeometricObject implements Colorable {
    public Square() {
        super();
    }
    public Square(String color,boolean filled) {
        super(color,filled);
    }
    @Override
    public void howToColor() {
        System.out.println("Set color is " + getColor());
    }
    public String toString() {
        return super.toString();
    }
}

public class LoserColorable {
    public static void main(String[] args) {
        GeometricObject[] array = new GeometricObject[5];
        array[0] = new Square("white",true);
        array[1] = new Square("blue",false);
        array[2] = new Square("green",true);
        array[3] = new Square("black",false);
        array[4] = new Square("red",true);
        for(GeometricObject i : array) {
            System.out.println(i.toString());
            i.howToColor();
        }

        /**
         *         List<Square> list = new ArrayList<>();
         *         list.add(new Square(1.0,"white",true));
         *         list.add(new Square(2.3,"blue",false));
         *         list.add(new Square(9.9,"red",true));
         *         list.add(new Square(1.0,"orange",true));
         *         list.add(new Square(6.6,"black",false));
         *         System.out.println(list.toString());
         */
    }
}
