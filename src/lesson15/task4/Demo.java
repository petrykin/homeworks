package lesson15.task4;

public class Demo {
    public static void main(String[] args) {
        Deanery deanery = new Deanery();
        deanery.fillStudentsList();
        deanery.fillStudentsSummaryList();
        System.out.println("Список всех студентов после сессии:");
        deanery.printStudentsInfo();
        deanery.makeDecision();
        System.out.println("Список студентов, которые перешли на следующий курс:");
        deanery.printStudentsInfo();
        System.out.println("Список выпускников:");
        deanery.printGraduatesInfo();
    }
}
