package lesson11.task2;

public class Tie extends Clothes implements IMaleClothes{
    public Tie(Sizes size, String color) {
        super(size, color);
    }

    public Tie(Sizes size, String color, double cost) {
        super(size, color, cost);
    }

    @Override
    public String toString() {
        return "Галстук{" +
                "размер = " + getSize() +
                ", цена = " + getCost() + " грн" +
                ", цвет = " + getColor() +
                "}";
    }
}
