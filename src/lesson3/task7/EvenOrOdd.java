package lesson3.task7;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer number, please:");
        System.out.println(isEven(getNextInt(scanner)));
    }

    private static boolean isEven(int x) {
        return (x & 1) != 1;
    }

    private static int getNextInt(Scanner scanner){
        while (!scanner.hasNextInt()) {
            System.out.println("Input error! Your number isn't integer! Try again, please:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
