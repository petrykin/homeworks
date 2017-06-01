package lesson13.task4;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculatorDemo {
    public static void main(String[] args) {
        printAllResults(getArrayOfCalcOperations());
    }

    public static double[] getArrayOfCalcOperations() {
        return new double[]{
                Calculator.divide(54, 15.5),
                Calculator.sum((short) 5, 158L),
                Calculator.multiply((byte) 8, 7.0f),
                Calculator.subtraction((long) 17, (short) 15)
        };
    }

    public static void printAllResults(double[] results) {
        NumberFormat nf = getNumberFormat();
        for (double result : results) {
            System.out.println("result = " + nf.format(result) + ";");
        }
    }

    public static NumberFormat getNumberFormat() {
        NumberFormat nf = NumberFormat.getInstance(Locale.ROOT);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf;
    }
}
