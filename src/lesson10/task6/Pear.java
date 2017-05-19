package lesson10.task6;

import static lesson10.task6.FruitMarket.Fruits.PEAR;

public class Pear extends Fruit {
    private static int count;
    private static double totalWeight;

    public Pear() {
        super("Груша");
        setWeight(0.25 * (Math.random() + 1));
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
        return getWeight() * PEAR.getPrice();
    }

    @Override
    public String toString() {
        return "Pear{" +
                "name='" + getName() + "\'" +
                ", weight=" + getWeight() +
                "}";
    }
}
