package lesson13.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestGMatrix {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("src\\lesson13\\task2\\TestFile.txt")) {
            GMatrix<Double> a = new GMatrix<>(getDoubleArray2D());
            System.out.println("Matrix A:\n" + a);
            a.toFile(fw, "A");

            GMatrix<Integer> b = new GMatrix<>(getIntArray2D());
            System.out.println("Matrix B:\n" + b);
            a.toFile(fw, "B");

            GMatrix c = b.add(a);
            System.out.println("Matrix C = A + B:\n" + c);
            a.toFile(fw, "C = A + B");

            GMatrix d = a.multiply(2);
            System.out.println("Matrix D = A * 2:\n" + d);
            a.toFile(fw, "D = A * 2");

            GMatrix e = b.subtract(a);
            System.out.println("Matrix E = B - A:\n" + e);
            a.toFile(fw, "E = B - A");

            GMatrix<Short> f = new GMatrix<>(new Short[][]{{1, 2}, {3, 4}});
            System.out.println("Matrix F:\n" + f);
            a.toFile(fw, "F");
            System.out.println("Matrix G = F * F:\n" + f.multiply(f));
            a.toFile(fw, "G = F * F");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Double[][] getDoubleArray2D() {
        return new Double[][]{
                {Math.random(), Math.random(), Math.random()},
                {Math.random(), Math.random(), Math.random()},
                {Math.random(), Math.random(), Math.random()}
        };
    }

    public static Integer[][] getIntArray2D() {
        return new Integer[][]{
                {new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10)},
                {new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10)},
                {new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10)}
        };
    }
}
