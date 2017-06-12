package lesson14.task4;

public class Student {
    private String name;
    private int course;

    public Student(String name, int course) {
        this(name);
        this.course = course;
    }

    public Student(String name) {
        this.name = name;
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
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (course != student.course) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + course;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name: '" + name + '\'' +
                ", course: " + course +
                '}';
    }
}
