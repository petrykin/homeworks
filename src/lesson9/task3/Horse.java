package lesson9.task3;

public class Horse extends Animal {
    private double weight;

    public Horse() {
    }

    public Horse(String food, String location) {
        super(food, location);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест.");
    }

    @Override
    public String makeNoise() {
        return "Иго-го-го-го!!!";
    }

    @Override
    public String toString() {
        return "Horse{" +
                "food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
