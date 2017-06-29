package lesson16.task2.model;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static lesson16.task2.model.Category.*;

public class CategoryDAO{
    public Set<Category> getAll() {
        SortedSet<Category> categories = new TreeSet<>(Comparator.comparing(Category::getName));
        categories.add(VIDEOCARD);
        categories.add(CPU);
        categories.add(MOTHERBOARD);
        categories.add(MEMORY);
        categories.add(HDD);
        categories.add(POWER);
        categories.add(SOUNDCARD);
        return categories;
    }
}
