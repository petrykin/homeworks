package lesson4.task7;

import java.util.ArrayList;

public class Average {
    private ArrayList<Double> doubleValues;

    public Average() {
        doubleValues = new ArrayList<>();
    }

    public void readArguments(String[] args) {
        for (String arg : args) {
            readNextArgument(arg);
        }
        printEnteredDoubleNumbers();
    }

    private void readNextArgument(String s) {
        try {
            doubleValues.add(Double.parseDouble(s));
        } catch (NumberFormatException e) {
            printParseToDoubleError(s);
        }
    }

    private void printParseToDoubleError(String s) {
        System.out.println("Argument: " + s + " isn't a double value. We won't consider it.");
    }

    private double getAverage() {
        if (doubleValues.size() == 0) {
            return Double.NaN;
        } else {
            return getSumOfAllDoubleArguments() / getQuantityOfAllDoubleArguments();
        }
    }

    private double getSumOfAllDoubleArguments() {
        double sum = 0.0;
        for (Double arg : doubleValues) {
            sum += arg;
        }
        return sum;
    }

    private int getQuantityOfAllDoubleArguments() {
        return doubleValues.size();
    }

    private void printEnteredDoubleNumbers() {
        System.out.print("\nEntered double numbers are ");
        for (Double doubleValue : doubleValues) {
            System.out.print(doubleValue + " ");
        }
        System.out.println();
    }

    public void printAverageValue() {
        double result = getAverage();
        if (!Double.isNaN(result)) {
            System.out.println("The average amount of entered double numbers is " + result);
        } else {
            System.out.println("Sorry! You have entered only incorrect values.");
        }
    }
}
