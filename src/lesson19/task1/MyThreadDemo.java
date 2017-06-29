package lesson19.task1;

public class MyThreadDemo {
    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            new Thread(new MyThread(), String.valueOf(i)).start();
        }
    }
}
