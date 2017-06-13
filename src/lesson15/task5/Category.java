package lesson15.task5;

import lesson14.task5.Item;

import java.util.*;

public class Category {
    private String name;
    private List<Item> itemList;

    public Category(String name) {
        this.name = name;
        itemList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void addItems(Collection<Item> items) {
        itemList.addAll(items);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public void removeItems(Collection<Item> items) {
        itemList.removeAll(items);
    }

    public List<Item> sortByName() {
        Collections.sort(itemList, Comparator.comparing(Item::getName));
        return itemList;
    }

    public List<Item> reverseSortByName() {
        Collections.sort(itemList, Collections.reverseOrder(Comparator.comparing(Item::getName)));
        return itemList;
    }

    public List<Item> sortByPrice() {
        Collections.sort(itemList, Comparator.comparing(Item::getPrice));
        return itemList;
    }

    public List<Item> reverseSortByPrice() {
        Collections.sort(itemList, Collections.reverseOrder(Comparator.comparing(Item::getPrice)));
        return itemList;
    }

    public List<Item> sortByRating() {
        Collections.sort(itemList, Comparator.comparing(Item::getRating));
        return itemList;
    }

    public List<Item> reverseSortByRating() {
        Collections.sort(itemList, Collections.reverseOrder(Comparator.comparing(Item::getRating)));
        return itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!name.equals(category.name)) return false;
        return itemList != null ? itemList.equals(category.itemList) : category.itemList == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (itemList != null ? itemList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name: '" + name + '\'' +
                ", itemList: " + itemList +
                '}';
    }
}
