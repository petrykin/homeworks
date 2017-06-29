package lesson16.task2.model;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {
    private String name;
    private double price;
    private int rank;
    private Category category;

    public Item(String name, double price, int rank, Category category) {
        this.name = name;
        this.price = price;
        this.rank = rank;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (Double.compare(item.price, price) != 0) return false;
        if (rank != item.rank) return false;
        if (!name.equals(item.name)) return false;
        return category == item.category;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + rank;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name: '" + name + '\'' +
                ", price: " + price +
                ", rank: " + rank +
                ", category: " + category.getName() +
                '}';
    }

    @Override
    public int compareTo(Item item) {
        return name.compareTo(item.getName());
    }
}
