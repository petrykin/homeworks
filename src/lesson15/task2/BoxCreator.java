package lesson15.task2;

import java.util.ArrayList;
import java.util.List;

public class BoxCreator {
    public static List<HeavyBox> create(int quantity) {
        List<HeavyBox> heavyBoxes = new ArrayList<>();
        while (quantity-- > 0) {
            heavyBoxes.add(new HeavyBox(Math.random() * 100, Math.random() * 100, Math.random() * 100, (int) (Math.random() * 500) + 100));
        }
        return heavyBoxes;
    }
}
