package lesson19_20.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task implements Sortable{
    private String name;
    private List<Double> list;

    public Task(String name) {
        this.name = name;
        list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(Math.random());
        }
    }

    public String getName() {
        return name;
    }

    public List<Double> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!name.equals(task.name)) return false;
        return list != null ? list.equals(task.list) : task.list == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void sort() {
        Collections.sort(list);
    }
}
