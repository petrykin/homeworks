package lesson12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    public static Matcher getMatcher(String regexp, String text) {
        Pattern pattern = Pattern.compile(regexp);
        return pattern.matcher(text);
    }

    public static List<String> getAllEntries(String regexp, String text) {
        List<String> words = new ArrayList<>();
        Matcher m = getMatcher(regexp, text);
        while (m.find()) {
            words.add(text.substring(m.start(), m.end()));
        }
        return words;
    }

    public static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word).reverse();
        return word.equals(sb.toString());
    }
}
