package lesson14.task4;

import java.util.LinkedList;
import java.util.List;

public class Deanery {
    public static int START_COURSE = 1;
    public static int FINISH_COURSE = 5;
    private List<Student> students;

    public Deanery() {
        students = new LinkedList<>();
        fillStudentsList();
    }

    public Deanery(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void fillStudentsList() {
        students.add(new Student("Иванов Иван Иванович", 5));
        students.add(new Student("Петров Петр Петрович", 4));
        students.add(new Student("Сидоров Сидор Сидорович", 3));
        students.add(new Student("Николаев Николай Николаевич", 2));
        students.add(new Student("Прокофьев Прокофий Прокофьевич", 1));
        students.add(new Student("Соломонов Соломон Соломонович", 5));
        students.add(new Student("Игнатьев Игнат Игнатьевич", 4));
        students.add(new Student("Сергеев Сергей Сергеевич", 3));
        students.add(new Student("Алексеев Алексей Алексеевич", 2));
        students.add(new Student("Романов Роман Романович", 1));
        students.add(new Student("Андреев Андрей Андреевич", 5));
        students.add(new Student("Валерьев Валерий Валерьевич", 4));
    }
}
