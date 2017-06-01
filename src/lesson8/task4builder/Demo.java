package lesson8.task4builder;

public class Demo {
    public static void main(String[] args) {
        Flower flower = new FlowerBuilder().name("Роза").build();
        System.out.println(flower);
    }
}
