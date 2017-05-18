package lesson9.task1;

import lesson8.task4.Flower;
import lesson8.task4.FlowerMarket;

public class Tulip extends Flower {
    private static int count;

    public Tulip() {
        super.setName("Тюльпан");
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void printSoldFlowerInfo() {
        System.out.printf("На текущий момент продано тюльпанов - %d шт\n\n", getCount());
    }

    @Override
    public double getCost() {
        return FlowerMarket.Flowers.TULIP.getPrice();
    }
}
