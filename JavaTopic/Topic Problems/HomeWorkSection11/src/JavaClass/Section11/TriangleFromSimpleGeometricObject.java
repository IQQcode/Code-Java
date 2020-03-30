package JavaClass.Section11;

import java.util.Date;
import java.util.Scanner;

class SimpleGeometricObject {
    String color = "white";
    boolean filled;
    private Date dateCreated;

    public SimpleGeometricObject() {
        dateCreated = new Date();
    }

    public SimpleGeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public String toString0() {
        return "created on" + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
}

class Triangle extends SimpleGeometricObject {
     double side1 = 1.0;
     double side2 = 1.0;
     double side3 = 1.0;

    public Triangle() { }

    public Triangle(double side1,double side2,double side3,String color,boolean filled) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setColor(color);
        setFilled(filled);
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        return side1 * side2 * side3;
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "created on side is " + side1 + " " + side2 +
                " " + side3 + "\nArea is " + getArea() +
                "\nPerimeter is " + getPerimeter();
    }
}

public class TriangleFromSimpleGeometricObject {
    public static void main(String[] args) {
        SimpleGeometricObject simple = new SimpleGeometricObject();
        System.out.println("A triangle" + simple.toString());
        System.out.println("The color is " + simple.getColor());

        Triangle triangle = new Triangle(3,4,5,
                "pink",true);
        System.out.println("\n\nA triangle" + triangle.toString0());
        System.out.println("A triangle" + triangle.toString());
        System.out.println("The color is " + triangle.getColor());
        System.out.println("The area is " + triangle.getArea());
        System.out.println("The diameter is " + triangle.getPerimeter());
    }
}
