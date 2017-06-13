package lesson15.task2;

import java.util.Formatter;
import java.util.Locale;

public class HeavyBox extends Box {
    private int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public HeavyBox(double width, double height, double depth, int weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    public HeavyBox(double len, int weight) {
        super(len);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeavyBox)) return false;
        if (!super.equals(o)) return false;

        HeavyBox heavyBox = (HeavyBox) o;

        return weight == heavyBox.weight;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                new Formatter().format(Locale.ROOT, "width = %.1f, height = %.1f, depth = %.1f, weight = %d}",
                        getWidth(), getHeight(), getDepth(), weight);
    }
}
