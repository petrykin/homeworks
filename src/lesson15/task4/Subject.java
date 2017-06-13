package lesson15.task4;

import java.util.ArrayList;
import java.util.List;

public enum Subject {
    MATHEMATICS(1, 2, 3, 4, 5),
    PHYSICS(3, 4, 5),
    CHEMISTRY(1),
    ENGLISH(2, 3, 4),
    UKRAINIAN(1, 2, 3),
    HISTORY(1, 2);

    Subject(Integer... courses) {
        this.courses = new ArrayList<>();
        for (Integer course : courses) {
            this.courses.add(course);
        }
    }

    public List<Integer> getCourses() {
        return courses;
    }

    private List<Integer> courses;
}
