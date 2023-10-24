package Lecture_14;

import java.awt.*;
import java.awt.geom.Area;

public class Test {
    public static void AreaCalculator(Shape s)
    {
        System.out.println(s.getArea());
    }
    public static void main(String[] args) {
        Shape s = new Shape( 10, 20, "blue");
        Circle c = new Circle(10, 20, "red", 100);
        AreaCalculator(s);
        AreaCalculator(c);

        Shape [] sArr = new Shape[3];
        sArr[0]  = new Shape(12, 10, "ds");
        sArr[1] = new Circle(12, 1, "blue", 3);
        sArr[2] = new Ractangle(1, 1, "a", 1, 2);

        for(Shape s1: sArr)
        {
            System.out.println(s1 instanceof Circle);
            System.out.println(s1.getArea());
        }
    }
}

 class Shape
{
    private int x, y;
    private String color;

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public  double getArea() {return -1;}
}
     class  Circle extends Shape
{
    int radius;

    public Circle(int x, int y, String color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
class Ractangle extends Shape
{
    private double length, height;

    public Ractangle(int x, int y, String color, double lenght, double height) {
        super(x, y, color);
        this.length = lenght;
        this.height = height;
    }

    public double getLenght() {
        return length;
    }

    public void setLenght(double lenght) {
        this.length = lenght;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getArea()
    {
        return length*height;

    }
}
