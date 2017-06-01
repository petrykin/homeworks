package lesson8.task4builder;

public class FlowerBuilder {
    private String name;

    public FlowerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Flower build() {
        return new Flower(this);
    }
}
