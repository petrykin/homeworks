package lesson11.task2;

import javafx.scene.paint.Color;

public class TeeShirt extends Clothes implements IMaleClothes, IFemaleClothes{
    public TeeShirt(Sizes size, String color) {
        super(size, color);
    }

    public TeeShirt(Sizes size, String color, double cost) {
        super(size, color, cost);
    }

    @Override
    public String toString() {
        return "Футболка{" +
                "размер = " + getSize() +
                ", цена = " + getCost() + " грн" +
                ", цвет = " + getColor() +
                "}";
    }
}
