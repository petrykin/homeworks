package lesson12.task6;

public class Demo {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов Иван Иванович", 3500),
                new Employee("Петров Петр Петрович", 4000),
                new Employee("Сидоров Сидор Сидорович", 4150),
                new Employee("Зозуля Зоя Петровна", 3200),
                new Employee("Лукьянова Тамара Ивановна", 3700),
        };

        Report.generateReport(employees);
    }
}
