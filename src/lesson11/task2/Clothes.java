package lesson11.task2;

public abstract class Clothes {
    private Sizes size;
    private String color;
    private double cost;

    public Clothes(Sizes size, String color) {
        this.size = size;
        this.color = color;
    }

    public Clothes(Sizes size, String color, double cost) {
        this(size, color);
        this.cost = cost;
    }

    public Sizes getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clothes)) return false;

        Clothes clothes = (Clothes) o;

        if (Double.compare(clothes.cost, cost) != 0) return false;
        if (size != clothes.size) return false;
        return color.equals(clothes.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = size.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }
}
