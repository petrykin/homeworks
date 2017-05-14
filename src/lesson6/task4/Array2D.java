package lesson6.task4;

import java.util.Locale;
import java.util.Random;

public class Array2D {
    public double getRandom() {
        return new Random().nextDouble() * 90 + 10;
    }

    public void printArray(double[][] arrs) {
        for (double[] arr : arrs) {
            for (double v : arr) {
                System.out.printf(Locale.ROOT, " %2.2f\t", v);
            }
            System.out.println();
        }
    }

    public double[][] get2DMinMaxArray(double[][] arr) {
        double[][] minMax = new double[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            minMax[i] = get1DMinMaxArray(arr[i]);
        }
        return minMax;
    }

    public double[] get1DMinMaxArray(double[] arr){
        double[] minMax = {arr[0], arr[0]};
        for (double value : arr) {
            if (value < minMax[0]) {
                minMax[0] = value;
            }
            if (value > minMax[1]) {
                minMax[1] = value;
            }
        }
        return minMax;
    }
}
