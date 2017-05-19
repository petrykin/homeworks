package lesson10.task6;

public class FruitMarket {
    public enum Fruits {
        APPLE("Яблоко", 15), PEAR("Груша", 30), APRICOT("Абрикос", 50);

        Fruits(String name, double price) {
            this.name = name;
            this.price = price;
        }

        private final double price;
        private final String name;

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }
    }
}
