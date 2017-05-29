package lesson13.task3;

import java.util.Random;

public class MinMaxDemo {
    public static void main(String[] args) {
        MinMax<Character> aChar = new MinMax<>(new Character[]{'a', 'k', 'r', 'd'});
        printMinMaxInfo(aChar);
        System.out.println();

        MinMax<Integer> aInt = new MinMax<>(new Integer[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        });
        printMinMaxInfo(aInt);
        System.out.println();

        MinMax<Double> aDouble = new MinMax<>(new Double[]{68.54, 71.75, 19.21, 7.88});
        printMinMaxInfo(aDouble);
    }

    public static void printMinMaxInfo(MinMax<?> arr) {
        System.out.println(arr);
        System.out.println("Минимальный элемент - \'" + arr.getMinElement() + '\'');
        System.out.println("Максимальный элемент - \'" + arr.getMaxElement() + '\'');
    }
}
