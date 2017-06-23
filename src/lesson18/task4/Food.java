package lesson18.task4;

public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public void prepare(Cookable c) {
        c.cook();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        return name.equals(food.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return '\"' + name.toUpperCase() + '\"';
    }
}
