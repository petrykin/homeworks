package lesson17.task1;

import java.io.*;

public class FileCopy {
    public static void copy(File src, File dst) {
        try (
                FileInputStream fis = new FileInputStream(src);
                FileOutputStream fos = new FileOutputStream(dst)
        ) {
            int a;
            while (fis.available() > 0) {
                fos.write(fis.read());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
