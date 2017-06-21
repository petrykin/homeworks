package lesson17.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
    public static String read(File src) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(src)) {
            int length = fis.available();
            for (int i = 0; i < length; i++) {
                sb.append((char) fis.read());
                sb.append(" ");
            }
        } catch (IOException e) {
            System.out.println("Input exception");
        }
        return sb.toString();
    }

    public static void write(File dst, char... sequence) {
        try (FileOutputStream fos = new FileOutputStream(dst)) {
            for (char c : sequence) {
                fos.write(c);
            }
        } catch (IOException e) {
            System.out.println("Output exception");
        }
    }
}
