package lesson16.task2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ItemDAO {
    public Set<Item> getAll() {
        Set<Item> itemSet = new HashSet<>();
        String fileName = "src\\lesson16\\task2\\model\\db\\items.db";
        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.lines().forEach(s -> {
                String[] data = s.split(":");
                itemSet.add(new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), Category.valueOf(data[3])));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemSet;
    }
}
