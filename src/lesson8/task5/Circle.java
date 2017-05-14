package lesson8.task5;

public class Circle {
    public final static double PI = 3.14159265;
    private double radius;

    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0.0;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircleLength() {
        return 2.0 * PI * radius;
    }

    public double getCircleArea() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius = " + radius + " " +
                "length = " + getCircleLength() + " " +
                "area = " + getCircleArea() +
                '}';
    }
}
