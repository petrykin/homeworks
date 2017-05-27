package lesson12.task2;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String text = getText();
        printInfo(Searcher.getAllEntries("[A-Za-z]+", text));
    }

    public static String getText() {
        return "Методы доступа называют ещё аксессорами (от англ. access — доступ)" +
                ", или по отдельности — геттерами (англ. get — чтение)" +
                " and сеттерами (англ. set — запись)";
    }

    public static void printInfo(List<String> words) {
        System.out.printf("В данном тексте слов состоящих только из латинских букв %d:%n", words.size());
        String s = "";
        for (String word : words) {
            s = !s.equals("") ? String.join(", ", s, word) : word;
        }
        System.out.println(s);
    }
}
