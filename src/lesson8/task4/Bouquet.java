package lesson8.task4;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Bouquet {
    private Flower[] flowers;

    public Bouquet(Flower... flowers) {
        this.flowers = flowers;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public double getBouquetCost() {
        double cost = 0.0;
        for (Flower flower : flowers) {
            cost += flower.getCost();
        }
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Букет состоит из:\n");
        Map<String, Integer> consist = getBouquetConsist();
        for (Map.Entry<String, Integer> pair : consist.entrySet()) {
            info.append(pair.getKey());
            info.append(" - ");
            info.append(pair.getValue());
            info.append(" шт\n");
        }
        return info.toString();
    }

    private Map<String, Integer> getBouquetConsist() {
        Map<String, Integer> consist = new HashMap<>();
        for (Flower flower : flowers) {
            if (!consist.containsKey(flower.getName())) {
                consist.put(flower.getName(), 1);
            } else {
                consist.put(flower.getName(), consist.get(flower.getName()) + 1);
            }
        }
        return consist;
    }
}
