package lesson14.task1;

import lesson8.task1.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksDB {
    private List<Book> bookList;

    public BooksDB() {
        bookList = new ArrayList<>();
    }

    public BooksDB(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void insertBook(Book book) {
        bookList.add(book);
    }

    public boolean removeBook(Book book) {
        if (bookList.contains(book)) {
            bookList.remove(book);
            return true;
        }
        return false;
    }

    public void printAll() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
