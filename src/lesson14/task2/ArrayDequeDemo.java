package lesson14.task2;

import lesson7.task1.Person;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Queue<Person> personsQueue = new ArrayDeque<>();
        personsQueue.add(new Person("Иванов Иван Иванович"));
        personsQueue.add(new Person("Петров Петр Петрович"));
        personsQueue.add(new Person("Сидоров Сидор Сидорович"));
        personsQueue.add(new Person("Николаев Николай Николаевич"));
        personsQueue.add(new Person("Сергеев Сергей Сергеевич"));
        System.out.println("Сейчас в очереди " + personsQueue.size() + " человек.");

        while (!personsQueue.isEmpty()) {
            System.out.println(personsQueue.remove() + " покидает очередь");
            System.out.println("Сейчас в очереди " + personsQueue.size() + " человек.");
        }
    }
}
