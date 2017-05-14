package lesson8.task4;

import java.util.Locale;

public class Flower {
    private String name;
    private double cost;
    private static int soldFlowerCount;

    public Flower() {
        soldFlowerCount++;
    }

    public Flower(String name, double cost) {
        this();
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double monetaryValue) {
        this.cost = monetaryValue;
    }

    public static int getSoldFlowerCount() {
        return soldFlowerCount;
    }

    public static void printSoldFlowerInfo() {
        System.out.printf(Locale.ROOT, "На текущий момент продано цветов - %d шт\n\n", Flower.getSoldFlowerCount());
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
