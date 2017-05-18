package lesson10.task9;

public class Main {
    public static void main(String[] args) {
        Printable[] printables = new Printable[6];
        printables[0] = new Book();
        printables[1] = new Magazine();
        printables[2] = new Book();
        printables[3] = new Magazine();
        printables[4] = new Book();
        printables[5] = new Magazine();

        for (Printable printable : printables) {
            printable.print();
        }
    }
}
