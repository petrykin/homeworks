package lesson16.task2.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bucket implements Serializable {
    private Map<Item, Integer> items;

    public Bucket() {
        items = new LinkedHashMap<>();
    }

    public Bucket(Map<Item, Integer> items) {
        this.items = items;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (!items.containsKey(item)) {
            items.put(item, 1);
        } else {
            items.put(item, items.get(item) + 1);
        }
    }

    public void removeItem(Item item) {
        if (items.containsKey(item)) {
            items.remove(item);
        }
    }

    public void clearBucket() {
        items.clear();
    }

    public int size() {
        int size = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            size += entry.getValue();
        }
        return size;
    }

    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            for (Map.Entry<Item, Integer> itemEntry : items.entrySet()) {
                os.writeObject(itemEntry.getKey());
                os.writeObject(itemEntry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is) {
        try {
            is.defaultReadObject();
            while (is.available() > 0) {
                Item item = (Item) is.readObject();
                int quantity = is.readInt();
                items.put(item, quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bucket)) return false;

        Bucket bucket = (Bucket) o;

        return items.equals(bucket.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder bucketItem = new StringBuilder();
        for (Map.Entry<Item, Integer> itemEntry : items.entrySet()) {
            bucketItem.append(itemEntry.getKey());
            bucketItem.append("\t");
            bucketItem.append("Количество: ");
            bucketItem.append(itemEntry.getValue());
            bucketItem.append("\n");
        }
        return bucketItem.toString();
    }
}
