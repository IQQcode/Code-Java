package www.javaExperiment;

import java.util.Scanner;

/**
 * 对一元二次方程求根
 */

class Equation {
    private double a = 0;
    private double b = 0;
    private double c = 0;
    public Equation() {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(double a,double b,double c) {
        return (b*b - 4*a*c);
    }

    public double getRoot1(double a,double b,double c) {
        double r1 = (-b + Math.sqrt(b*b - 4*a*c)) / 2 * a;
        return  r1;
    }
    public double getRoot2(double a,double b,double c) {
        double r2 = (-b - Math.sqrt(b*b - 4*a*c)) / 2 * a;
        return r2;
    }
}

public class QuadraticEquation {
    public static void main(String[] args) {
        Equation equation = new Equation();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter three number a,b,c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        System.out.print("要求解的方程为：" + a + "*x*x + " +
                b + "*x + " + c + " = 0");
        System.out.println("\n方程的判别式为:" + equation.getDiscriminant(a,b,c));

        if(equation.getDiscriminant(a,b,c) >= 0) {
            System.out.println("\n方程的根为：" + equation.getRoot1(a,b,c) +
                    " " + equation.getRoot2(a,b,c));
        }else {
            System.out.println("The equation has no roots...");
        }
    }
}

