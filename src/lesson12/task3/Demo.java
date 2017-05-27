package lesson12.task3;

import lesson12.task2.Searcher;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String text = getText();
        printInfo(Searcher.getAllEntries("\\d+", text));
    }

    public static String getText() {
        return "10001 1111001 001010 0001111000 110101010 10101010101 000111 1111000010101";
    }

    public static void printInfo(List<String> words) {
        System.out.println("Палиндромы встречающиеся в данной строке:");
        String s = "";
        for (String word : words) {
            if (Searcher.isPalindrome(word)) {
                s = !s.equals("") ? String.join(", ", s, word) : word;
            }
        }
        System.out.println(s);
    }
}
