package lesson6.task3;

import java.util.Arrays;

import static lesson6.task3.Factorial.*;

public class FactorialTest {
    public static void main(String[] args) {
        int[] numbers = getRandomIntArray(1);
        Arrays.sort(numbers);

        long start = getTime();
        for (int number : numbers) {
            printFactorial(number, getFactorialByForCycle(number).toString());
        }
        long stop = getTime();
        printDuration(start, stop, "for-cycle");

        start = getTime();
        for (int number : numbers) {
            printFactorial(number, getFactorialByRecursion(number).toString());
        }
        stop = getTime();
        printDuration(start, stop, "recursion");
    }
}
