package lesson8.task4;

import java.util.Locale;

import static lesson8.task4.FlowerMarket.Flowers.*;

public class Demo {
    public static void main(String[] args) {
        FlowerMarket market = new FlowerMarket();

        Bouquet bouquet = market.getBouquet(ROSE, ROSE, ROSE, ROSE, ROSE);
        printInfo(bouquet);
        Flower.printSoldFlowerInfo();

        bouquet = market.getBouquet(LILY, ORCHID, PEONY, ASTER, ASTER, LILY, LILY);
        printInfo(bouquet);
        Flower.printSoldFlowerInfo();

        bouquet = market.getBouquet(ASTER, ASTER, ASTER);
        printInfo(bouquet);
        Flower.printSoldFlowerInfo();
    }

    private static void printInfo(Bouquet bouquet) {
        System.out.print(bouquet);
        System.out.printf(Locale.ROOT, "Стоимость букета: %.2f грн\n\n", bouquet.getBouquetCost());
    }
}
