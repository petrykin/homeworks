package lesson14.task4;

import java.util.Iterator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        printStudentsPerCourses(new Deanery().getStudents());
    }

    public static void printStudentsPerCourses(List<Student> students) {
        for (int i = Deanery.START_COURSE; i <= Deanery.FINISH_COURSE; i++) {
            System.out.println("Список студентов " + i + " курса:");
            printStudents(students, i);
            System.out.println();
        }
    }

    public static void printStudents(List<Student> students, int course) {
        Iterator<Student> iterator = students.listIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
