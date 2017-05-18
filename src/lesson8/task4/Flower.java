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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (Double.compare(flower.cost, cost) != 0) return false;
        return name.equals(flower.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
