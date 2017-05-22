package lesson10.task6;

public class Pear extends Fruit {
    private static int count;
    private static double totalWeight;
    private static double totalCost;

    public Pear() {
        super("Груша");
        setWeight(0.25 * (Math.random() + 1));
        totalWeight += getWeight();
        count++;
    }

    public Pear(double price) {
        this();
        this.setPrice(price);
        totalCost += getCost();
    }

    public static int getCount() {
        return count;
    }

    public static double getTotalWeight() {
        return totalWeight;
    }

    public static double getTotalCost() {
        return totalCost;
    }

    @Override
    public double getCost() {
        return getWeight() * this.getPrice();
    }

    @Override
    public String toString() {
        return "Pear{" +
                "name='" + getName() + "\'" +
                ", weight=" + getWeight() +
                "}";
    }
}
