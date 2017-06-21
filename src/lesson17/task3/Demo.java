package lesson17.task3;

import lesson9.task3.Horse;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        Horse horse = new Horse("Овес", "Конеферма", 450.0);
        File file = new File("src\\lesson17\\task3\\horse.ser");
        Serializer.serialize(horse, file);
        Horse newHorse = (Horse) Serializer.deserialize(file);
        System.out.println(newHorse);
    }
}
