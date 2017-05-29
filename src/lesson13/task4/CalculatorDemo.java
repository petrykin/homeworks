package lesson13.task4;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculatorDemo {
    public static void main(String[] args) {
        printAllResults(getArrayOfCalcOperations());
    }

    public  static double[] getArrayOfCalcOperations() {
        return new double[]{
                Calculator.divide(Integer.valueOf(54), Double.valueOf(15.5)),
                Calculator.sum(Short.valueOf((short) 5), Long.valueOf(158L)),
                Calculator.multiply(Byte.valueOf((byte)8), Float.valueOf((float)7.0)),
                Calculator.subtraction(Integer.valueOf(17), Byte.valueOf((byte) 15))
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
