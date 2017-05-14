package lesson9.task1;

import lesson8.task4.Bouquet;
import lesson8.task4.Flower;

import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        Rose[] roses = new Rose[1_000_000];
        for (int i = 0; i < roses.length; i++) {
            roses[i] = new Rose(50 * Math.random());
        }
        Bouquet bouquet = new Bouquet(roses);
        printInfo(bouquet);
        Flower.printSoldFlowerInfo();

        bouquet = new Bouquet(new Tulip(5), new Tulip(5),
                new Tulip(5), new Aster(10), new Aster(10));
        printInfo(bouquet);
        Flower.printSoldFlowerInfo();


        bouquet = new Bouquet(new Carnation(15), new Tulip(5),
                new Lily(30), new Herbera(35), new Rose(40));
        printInfo(bouquet);
        Flower.printSoldFlowerInfo();
    }

    private static void printInfo(Bouquet bouquet) {
        System.out.print(bouquet);
        System.out.printf(Locale.ROOT, "Стоимость букета: %.1f грн\n\n", bouquet.getBouquetCost());
    }
}
