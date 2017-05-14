package lesson4.task6;

public class Launcher {
    public static void main(String[] args) {
        LightView view = new LightView();

        while (true) {
            view.requestUserMode();
        }
    }
}
