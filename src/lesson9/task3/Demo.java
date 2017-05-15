package lesson9.task3;

public class Demo {
    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Каша и кости", "Двор частного дома");
        animals[1] = new Cat("Молоко и рыба", "Квартира");
        animals[2] = new Horse("Сено", "Конеферма");

        for (Animal animal : animals) {
            veterinarian.treatAnimal(animal);
        }
    }
}
