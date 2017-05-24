package lesson11.task3;

public class Demo {
    public static void main(String[] args) {
        Table table = new Table();
        table.printTable();
        table.toFile(".\\src\\lesson11\\task3\\table.txt");
    }
}
