package lesson10.figures;

import java.awt.*;

public class Circle extends Shape {
    private int xCenter;
    private int yCenter;

    public Circle() {
        super();
    }

    public Circle(int xCenter, int yCenter) {
        super();
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public Circle(Color color, int xCenter, int yCenter) {
        super(color);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    @Override
    public void draw() {
            System.out.println(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + getColor() +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (xCenter != circle.xCenter) return false;
        return yCenter == circle.yCenter;
    }

    @Override
    public int hashCode() {
        int result = xCenter;
        result = 31 * result + yCenter;
        return result;
    }
}
