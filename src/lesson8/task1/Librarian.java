package lesson8.task1;

import java.util.Map;

public class Librarian {
    private static BooksDB booksDB;

    public static void setBooksDB(BooksDB booksDB) {
        Librarian.booksDB = booksDB;
    }

    private static boolean isBookExist(int id) {
        return booksDB.getBooks().containsKey(id) && booksDB.getBook(id).isAvailable();
    }

    private static boolean isBookExist(String bookName) {
        for (Map.Entry<Integer, Book> entry : booksDB.getBooks().entrySet()) {
            if (entry.getValue().getBookName().equals(bookName) && entry.getValue().isAvailable()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBookExist(Book book) {
        for (Map.Entry<Integer, Book> entry : booksDB.getBooks().entrySet()) {
            if (entry.getValue().equals(book) && entry.getValue().isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public static Book getBook(int id) {
        if (isBookExist(id)) {
            booksDB.getBook(id).setAvailable(false);
            return booksDB.getBook(id);
        } else {
            return null;
        }
    }

    public static Book getBook(String bookName) {
        if (isBookExist(bookName)) {
            booksDB.getBook(bookName).setAvailable(false);
            return booksDB.getBook(bookName);
        } else {
            return null;
        }
    }

    public static Book getBook(Book book) {
        if (isBookExist(book)) {
            booksDB.getBook(book.getBookName()).setAvailable(false);
            return booksDB.getBook(book.getBookName());
        } else {
            return null;
        }
    }

    public static void returnBook(String bookName) {
        booksDB.getBook(bookName).setAvailable(true);
    }

    public static void returnBook(Book book) {
        booksDB.getBook(book.getBookName()).setAvailable(true);
    }
}
