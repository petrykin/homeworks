package lesson10.figures;

import java.awt.*;

public abstract class Shape {
    private Color color;

    public Shape() {
        this(new Color(0,0,0));
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
