package lesson15.task4;

import java.util.*;

public class Deanery {
    public static int START_COURSE = 1;
    public static int FINISH_COURSE = 5;

    private List<Student> students;
    private List<Student> graduates;

    public Deanery() {
        students = new LinkedList<>();
        graduates = new LinkedList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getGraduates() {
        return graduates;
    }

    public void setGraduates(List<Student> graduates) {
        this.graduates = graduates;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void fillStudentsList() {
        students.add(new Student("Иванов Иван Иванович", 5, "GR530"));
        students.add(new Student("Петров Петр Петрович", 4, "GR430"));
        students.add(new Student("Сидоров Сидор Сидорович", 3, "GR330"));
        students.add(new Student("Николаев Николай Николаевич", 2, "GR230"));
        students.add(new Student("Прокофьев Прокофий Прокофьевич", 1, "GR130"));
        students.add(new Student("Соломонов Соломон Соломонович", 5, "GR530"));
        students.add(new Student("Игнатьев Игнат Игнатьевич", 4, "GR430"));
        students.add(new Student("Сергеев Сергей Сергеевич", 3, "GR330"));
        students.add(new Student("Алексеев Алексей Алексеевич", 2, "GR230"));
        students.add(new Student("Романов Роман Романович", 1, "GR130"));
        students.add(new Student("Андреев Андрей Андреевич", 5, "GR530"));
        students.add(new Student("Валерьев Валерий Валерьевич", 4, "GR430"));
    }

    public void fillStudentsSummaryList() {
        for (Student student : students) {
            student.fillSummaryList();
        }
    }

    public void printStudentsInfo() {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public void printGraduatesInfo() {
        for (Student graduate : graduates) {
            System.out.println(graduate);
        }
        System.out.println();
    }

    public void makeDecision() {
        ListIterator<Student> iterator = students.listIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (averageMark(student) >= 3) {
                student.updateCourse();
                if (student.isGraduate()) {
                    iterator.remove();
                    graduates.add(student);
                } else {
                    iterator.set(student);
                }
            } else {
                iterator.remove();
            }
        }
    }

    public double averageMark(Student student) {
        double averageMark = 0;
        for (Integer integer : student.getResults().values()) {
            averageMark += integer;
        }
        averageMark /= student.subjectsNumber();
        return averageMark;
    }
}
