package lesson10.task6;

import static lesson10.task6.FruitMarket.Fruits.APRICOT;

public class Apricot extends Fruit {
    private static int count;
    private static double totalWeight;

    public Apricot() {
        super("Абрикос");
        setWeight(0.02 * (Math.random() + 1));
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
        return getWeight() * APRICOT.getPrice();
    }

    @Override
    public String toString() {
        return "Apricot{" +
                "name='" + getName() + "\'" +
                ", weight=" + getWeight() +
                "}";
    }
}
