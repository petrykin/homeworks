package lesson10.figures;

import java.awt.*;

public class Rectangle extends Shape {
    private int top;
    private int left;
    private int height;
    private int width;

    public Rectangle() {
        super();
    }

    public Rectangle(int top, int left, int height, int width) {
        super();
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public Rectangle(Color color, int top, int left, int height, int width) {
        super(color);
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color=" + getColor() +
                ", top=" + top +
                ", left=" + left +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
