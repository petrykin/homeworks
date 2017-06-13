package lesson15.task3;

public class Toy {
    private String name;
    private int сost;

    public Toy() {
    }

    public Toy(String name) {
        this();
        this.name = name;
    }

    public Toy(String name, int сost) {
        this(name);
        this.сost = сost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getСost() {
        return сost;
    }

    public void setСost(int сost) {
        this.сost = сost;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name = '" + name + '\'' +
                ", сost = " + сost +
                '}';
    }
}
