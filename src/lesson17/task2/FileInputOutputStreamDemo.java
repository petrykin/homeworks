package lesson17.task2;

import java.io.File;

public class FileInputOutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("src\\lesson17\\task2\\file.txt");
        FileInputOutputStream.write(file, new char[]{'a', 'b', 'c'});
        String fileText = FileInputOutputStream.read(file);
        System.out.print(fileText);
    }
}
