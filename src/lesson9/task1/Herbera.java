package lesson9.task1;

import lesson8.task4.Flower;
import lesson8.task4.FlowerMarket;

public class Herbera extends Flower {
    private static int count;

    public Herbera() {
        super.setName("Гербера");
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void printSoldFlowerInfo() {
        System.out.printf("На текущий момент продано гербер - %d шт\n\n", getCount());
    }

    @Override
    public double getCost() {
        return FlowerMarket.Flowers.HERBERA.getPrice();
    }
}
