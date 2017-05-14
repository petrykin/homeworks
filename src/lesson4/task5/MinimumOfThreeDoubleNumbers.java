package lesson4.task5;

import java.util.Scanner;

public class MinimumOfThreeDoubleNumbers {
    private static double getMin(double a, double b, double c) {
        return Math.abs(a) < Math.abs(b) ? (Math.abs(a) < Math.abs(c) ? a : c) : (Math.abs(b) < Math.abs(c) ? b : c);
    }

    private static double getNextDoubleNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка! Вы ввели не вещественное число. Повторите пожалуйста ввод:");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число a:");
        double a = getNextDoubleNumber(scanner);
        System.out.println("Введите число b:");
        double b = getNextDoubleNumber(scanner);
        System.out.println("Введите число c:");
        double c = getNextDoubleNumber(scanner);
        System.out.println("Наименьшее по модулю число: " + getMin(a, b, c));
    }
}
