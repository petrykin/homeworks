package lesson6.task1;

import java.util.ArrayList;
import java.util.List;

public class MultipleNumbers {
    public static void main(String[] args) {
        printArrayList(getMultipleNumbers(1, 100, 5));
    }

    public static void printArrayList(List<Integer> list) {
        for (Integer number : list) {
            System.out.printf("%d\t", number);
        }
    }

    public static ArrayList<Integer> getMultipleNumbers(int startRangeValue, int endRangeValue, int divisor) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int iterator = startRangeValue;
        do {
            if (iterator % divisor == 0) {
                numbers.add(iterator);
            }
        } while (++iterator <= endRangeValue);
        return numbers;
    }
}
