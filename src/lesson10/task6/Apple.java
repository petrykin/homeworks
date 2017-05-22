package lesson10.task6;

public class Apple extends Fruit {
    private static int count;
    private static double totalWeight;
    private static double totalCost;

    public Apple() {
        super("Яблоко");
        setWeight(0.1 * (Math.random() + 1));
        totalWeight += getWeight();
        count++;
    }

    public Apple(double price) {
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
        return "Apple{" +
                "name='" + getName() + "\'" +
                ", weight=" + getWeight() +
                "}";
    }
}
