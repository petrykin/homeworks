package lesson3.task8;

import java.util.Scanner;

public class SumOfTwoIntNumbers {

    private static class TwoIntNumbers {
        private static final int INT_NUMBERS_QUANTITY = 2;
        private static int sum;

        public static void readNextIntNumber(Scanner scanner){
            if (scanner.hasNextInt()){
                sum += scanner.nextInt();
            } else {
                System.out.println(inputError());
                System.exit(0);
            }
        }

        private static int getSum(Scanner scanner) {
            for (int i = 0; i < INT_NUMBERS_QUANTITY; i++) {
                readNextIntNumber(scanner);
            }
            return sum;
        }

        public static String inputError(){
            return "Ошибка! Вы ввели не целое число!";
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите два целых числа a и b: ");
        System.out.println("Сумма введенных чисел a + b = " + TwoIntNumbers.getSum(new Scanner(System.in)));
    }
}
