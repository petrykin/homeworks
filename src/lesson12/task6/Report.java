package lesson12.task6;

import java.util.Locale;

public class Report {
    public static void generateReport(Employee[] employees) {
        System.out.printf("|          ФИО          | %-10s |%n", "Оклад, грн");
        printBorder();
        for (Employee employee : employees) {
            String[] fio = employee.getFullName().split("\\s+");
            System.out.printf(Locale.ROOT, "|  %s.%s. %-16s|%12.2f|%n",
                    fio[1].substring(0, 1), fio[2].substring(0, 1), fio[0], employee.getSalary());
            printBorder();
        }
    }

    private static void printBorder() {
        System.out.printf("|-----------------------+------------|%n");
    }
}
