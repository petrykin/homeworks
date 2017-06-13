package lesson15.task1;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputOutput {
    private Set<Integer> numbersSet;

    public InputOutput() {
        numbersSet = new HashSet<>();
    }

    public InputOutput inputStringToNumbers(String userInputLine) {
        Matcher m = Pattern.compile("[0-9]+").matcher(userInputLine);
        while (m.find()) {
            numbersSet.add(Integer.valueOf(userInputLine.substring(m.start(), m.end())));
        }
        return this;
    }

    public void printNumbers() {
        for (Integer number : numbersSet) {
            System.out.print(number + " ");
        }
    }
}
