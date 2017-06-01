package lesson13.task4;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculatorDemo {
    public static void main(String[] args) {
        printAllResults(getArrayOfCalcOperations());
    }

    public  static double[] getArrayOfCalcOperations() {
        return new double[]{
                Calculator.divide(54, 15.5),
                Calculator.sum(5, 158L),
                Calculator.multiply(8, 7.0),
                Calculator.subtraction(17, 15)
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
