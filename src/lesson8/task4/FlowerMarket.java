package lesson8.task4;

public class FlowerMarket {
    public enum Flowers {
        ROSE("Роза", 40), ASTER("Астра", 15), HERBERA("Гербера", 25), LILY("Лилия", 30), ORCHID("Орхидея", 50), PEONY("Пион", 20);

        Flowers(String name, double price) {
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

    public Bouquet getBouquet(Flowers... flowers) {
        Flower[] flower = new Flower[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            flower[i] = new Flower(flowers[i].getName(), flowers[i].getPrice());
        }
        return new Bouquet(flower);
    }
}
