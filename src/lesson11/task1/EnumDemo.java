package lesson11.task1;

import java.util.Locale;

public class EnumDemo {
    public static void main(String[] args) {
        for (Seasons season : Seasons.values()) {
            printInfo(season);
        }
        System.out.print("\nЛюбимое время года: ");
        printInfo(Seasons.valueOf("SPRING"));
    }

    public static void printInfo(Seasons season) {
        System.out.printf(Locale.ROOT, "%s %s, ", season.name(), season);
        season.getDescription();
    }
}
