package lesson13.task3;

import java.text.NumberFormat;
import java.util.Arrays;

public class MinMax<T extends Comparable> {
    private T[] arr;
    private NumberFormat nf;

    public MinMax(T[] arr) {
        this.arr = arr;
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
    }

    public T getMinElement() {
        if (arr.length > 0) {
            T min = arr[0];
            for (T t : arr) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
            return min;
        }
        return null;
    }

    public T getMaxElement() {
        if (arr.length > 0) {
            T max = arr[0];
            for (T t : arr) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
            return max;
        }
        return null;
    }

    @Override
    public String toString() {
        return "MinMax<" + arr.getClass().getSimpleName() + ">{" + Arrays.toString(arr) + '}';
    }
}
