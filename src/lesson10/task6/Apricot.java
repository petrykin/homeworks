package lesson10.task6;

public class Apricot extends Fruit {
    private static int count;
    private static double totalWeight;
    private static double totalCost;

    public Apricot() {
        super("Абрикос");
        setWeight(0.02 * (Math.random() + 1));
        totalWeight += getWeight();
        count++;
    }

    public Apricot(double price) {
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
        return "Apricot{" +
                "name='" + getName() + "\'" +
                ", weight=" + getWeight() +
                "}";
    }
}
