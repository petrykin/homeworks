package lesson11.task2;

public interface IMaleClothes {
    default void dressMale() {
        System.out.println("Одеваем мужчину");
    }
}
