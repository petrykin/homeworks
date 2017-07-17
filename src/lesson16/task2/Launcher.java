package lesson16.task2;

import lesson16.task2.gui.MainWindow;

import javax.swing.*;

public class Launcher {
    public final static String splitter = "\\";

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new MainWindow();
    }
}
