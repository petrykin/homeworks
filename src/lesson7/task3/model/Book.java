package lesson7.task3.model;

public class Book {
    private String bookName;
    private String author;

    public Book(String name, String author) {
        this.bookName = name;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }
}
