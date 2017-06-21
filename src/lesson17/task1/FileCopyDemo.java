package lesson17.task1;

import java.io.File;

public class FileCopyDemo {
    public static void main(String[] args) {
        File source = new File("src\\lesson17\\task1\\src_pack\\java.png");
        File destination = new File("src\\lesson17\\task1\\dst_pack\\copied_java.png");
        FileCopy.copy(source, destination);
    }
}
