package lesson10.task6;

import static lesson10.task6.FruitMarket.Fruits.APPLE;

public class Apple extends Fruit {
    private static int count;
    private static double totalWeight;

    public Apple() {
        super("Яблоко");
        setWeight(0.1 * (Math.random() + 1));
        totalWeight += getWeight();
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static double getTotalWeight() {
        return totalWeight;
    }

    public static double getTotalCost(double costPerKg) {
        return getTotalWeight() * costPerKg;
    }

    @Override
    public double getCost() {
        return getWeight() * APPLE.getPrice();
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + getName() + "\'" +
                ", weight=" + getWeight() +
                "}";
    }
}
