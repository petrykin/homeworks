package lesson6.task3;

import java.math.BigInteger;
import java.util.Random;

public class Factorial {
    public static BigInteger getFactorialByForCycle(int n) {
        BigInteger f = BigInteger.ONE;
        if (n == 0) return f;
        for (int i = 1; i <= n; ++i) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    public static BigInteger getFactorialByRecursion(int n) {
        if (n == 0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(getFactorialByRecursion(n - 1));
    }

    public static long getTime() {
        return System.nanoTime();
    }

    public static int getRandomIntNumber() {
        return new Random().nextInt(50);
    }

    public static int[] getRandomIntArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = getRandomIntNumber();
        }
        return array;
    }

    public static void printFactorial(int n, String s) {
        System.out.println(n + "! = " + s);
    }

    public static void printDuration(long start, long stop, String s) {
        System.out.printf("factorial counting by %s: %,10f ms\n", s, (stop - start) * 1e-6);
    }
}
