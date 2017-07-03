package lesson19_20.task3;

import java.util.ArrayList;
import java.util.List;

public class Task {
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
    public String toString() {
        return name;
    }
}
