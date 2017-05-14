package lesson7.task2;

import java.io.FileWriter;
import java.io.IOException;

public class TestMatrix {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("matrix.txt");

        Matrix a = new Matrix(4, 4);
        a.fillRandom();
        a.print("A (random filled matrix)");
        a.toFile(fw, "A (random filled matrix)");

        Matrix b = new Matrix(new double[][]{{1, 2, 1, 2}, {2, 1, 2, 1}, {1, 2, 1, 2}, {2, 1, 2, 1}});
        b.print("B (manually filled matrix)");
        b.toFile(fw, "B (manually filled matrix)");

        Matrix c = a.add(b);
        c.print("C = A + B");
        c.toFile(fw, "C = A + B");

        Matrix d = c.multiply(2);
        d.print("D = C * 2");
        d.toFile(fw, "D = C * 2");

        Matrix m = c.divide(2);
        m.print("M = C / 2");
        m.toFile(fw, "M = C / 2");

        Matrix e = c.multiply(d);
        e.print("E = C * D");
        e.toFile(fw, "E = C * D");

        fw.close();
    }
}
