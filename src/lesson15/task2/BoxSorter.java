package lesson15.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoxSorter {
    public static List<HeavyBox> sort(List<HeavyBox> boxes, int weight) {
        List<HeavyBox> resultList = new ArrayList<>();
        Iterator<HeavyBox> iterator = boxes.listIterator();
        while (iterator.hasNext()) {
            HeavyBox currentBox = iterator.next();
            if (currentBox.getWeight() > weight) {
                resultList.add(currentBox);
                iterator.remove();
            }
        }
        return resultList;
    }
}
