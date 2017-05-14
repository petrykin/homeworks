package lesson3.task7;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пожалуйста целое число:");
        System.out.println(isEven(getNextInt(scanner)));
    }

    private static String isEven(int x) {
        String s = "Введенное число: " + x;
        s += (x & 1) == 1 ? " - нечетное" : " - четное";
        return s;
    }

    private static int getNextInt(Scanner scanner){
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Вы ввели не целое число! Повторите пожалуйста ввод:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
