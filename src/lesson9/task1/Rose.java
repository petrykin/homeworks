package lesson9.task1;

import lesson8.task4.Flower;
import lesson8.task4.FlowerMarket;

public class Rose extends Flower{
    private static int count;

    public Rose() {
        super.setName("Роза");
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void printSoldFlowerInfo() {
        System.out.printf("На текущий момент продано роз - %d шт\n\n", getCount());
    }

    @Override
    public double getCost() {
        return FlowerMarket.Flowers.ROSE.getPrice();
    }
}
