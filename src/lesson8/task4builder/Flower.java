package lesson8.task4builder;

public class Flower {
    private final String name;

    public Flower(FlowerBuilder builder) {
        this.name = builder.getName();
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                '}';
    }
}
