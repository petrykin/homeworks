package lesson14.task5;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Category {
    private String name;
    private SortedSet<Item> itemSet;

    public Category(String name, Comparator<Item> comparator) {
        this.name = name;
        itemSet = new TreeSet<>(comparator);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(SortedSet<Item> itemSet) {
        this.itemSet = itemSet;
    }

    public void addItem(Item item) {
        itemSet.add(item);
    }

    public void addItems(Collection<Item> items) {
        itemSet.addAll(items);
    }

    public void removeItem(Item item) {
        itemSet.remove(item);
    }

    public void removeItems(Collection<Item> items) {
        itemSet.removeAll(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!name.equals(category.name)) return false;
        return itemSet != null ? itemSet.equals(category.itemSet) : category.itemSet == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (itemSet != null ? itemSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name: '" + name + '\'' +
                ", itemSet: " + itemSet +
                '}';
    }
}
