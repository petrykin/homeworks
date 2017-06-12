package lesson14.task1;

import lesson8.task1.Book;

public class ArrayListDemo {
    public static void main(String[] args) {
        BooksDB books = new BooksDB();

        books.insertBook(new Book("Лев Толстой", "Война и мир"));
        books.insertBook(new Book("Джордж Оруэлл", "1984"));
        books.insertBook(new Book("Джейм Джойс", "Улисс"));
        books.insertBook(new Book("Данте Алигьери", "Божественная комедия"));
        books.insertBook(new Book("Джером Д. Сэлинджер", "Над пропастью во ржи"));

        System.out.println("Исходное состояние БД книг:");
        books.printAll();

        books.removeBook(new Book("Джейм Джойс", "Улисс"));
        System.out.println("\nСостояние БД книг после удаления:");
        books.printAll();
    }
}
