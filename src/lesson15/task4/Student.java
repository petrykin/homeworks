package lesson15.task4;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public class Student {
    private String name;
    private int course;
    private String group;
    private Map<Subject, Integer> results;

    public Student(String name, int course, String group) {
        this(name);
        this.course = course;
        this.group = group;
    }

    public Student(String name) {
        this.name = name;
        results = new EnumMap<>(Subject.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (Deanery.START_COURSE <= course && course <= Deanery.FINISH_COURSE) {
            this.course = course;
        }
    }

    public void updateCourse() {
        if (course < Deanery.FINISH_COURSE) {
            course++;
            group = group.substring(0, 2) + course + group.substring(3);
        } else {
            this.course = -1;
            group = "Выпускник";
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Map<Subject, Integer> getResults() {
        return results;
    }

    public void setResults(Map<Subject, Integer> results) {
        this.results = results;
    }

    public int subjectsNumber() {
        return results.size();
    }

    public void fillSummaryList() {
        for (Subject subject : Subject.values()) {
            if (subject.getCourses().contains(course)) {
                results.put(subject, new Random().nextInt(3) + 2);
            }
        }
    }

    public boolean isGraduate() {
        return course == -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (course != student.course) return false;
        if (!name.equals(student.name)) return false;
        return group != null ? group.equals(student.group) : student.group == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + course;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name: '" + name + '\'' +
                ", course: " + (course != -1 ? course : "-") +
                ", group: '" + group + '\'' +
                ", results: " + results +
                '}';
    }
}
