package lesson9.task1;

import lesson8.task4.Bouquet;

import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        Rose[] roses = new Rose[1_000_000];
        for (int i = 0; i < roses.length; i++) {
            roses[i] = new Rose();
        }
        Bouquet bouquet = new Bouquet(roses);
        printInfo(bouquet);

        bouquet = new Bouquet(new Tulip(), new Tulip(),
                new Tulip(), new Aster(), new Aster());
        printInfo(bouquet);

        bouquet = new Bouquet(new Carnation(), new Tulip(),
                new Lily(), new Herbera(), new Rose());
        printInfo(bouquet);
    }

    private static void printInfo(Bouquet bouquet) {
        System.out.print(bouquet);
        System.out.printf(Locale.ROOT, "Стоимость букета: %.1f грн\n\n", bouquet.getBouquetCost());
    }
}
