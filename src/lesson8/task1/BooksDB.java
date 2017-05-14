package lesson8.task1;

import java.util.HashMap;
import java.util.Map;

public class BooksDB {
    private Map<Integer, Book> books;

    public BooksDB() {
        books = new HashMap<>();
        books.put(Book.getBookCount(), new Book("Марк Твен", "Приключения Тома Сойера"));
        books.put(Book.getBookCount(), new Book("Паоло Коэльо", "Алхимик"));
        books.put(Book.getBookCount(), new Book("Макс Кидрук", "Твердыня"));
        books.put(Book.getBookCount(), new Book("А.С. Пушкин", "Стихи"));
        books.put(Book.getBookCount(), new Book("Тарас Шевченко", "Кобзар"));
        books.put(Book.getBookCount(), new Book("Макс Кидрук", "Бот"));
        books.put(Book.getBookCount(), new Book("Э. Распэ", "Приключения барона Мюнхгаузена"));
        books.put(Book.getBookCount(), new Book("А. Кун", "Мифы и легенды Древней Греции"));
        books.put(Book.getBookCount(), new Book("Аристотель", "Метафизика"));
        books.put(Book.getBookCount(), new Book("В.Г. Короленко", "Слепой музыкант"));
        books.put(Book.getBookCount(), new Book("Лао Цзы", "Искусство войны"));
    }

    public Book getBook(int idNumber) {
        return books.get(idNumber);
    }

    public Book getBook(String bookName) {
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (entry.getValue().getBookName().equals(bookName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void printAvailableBooksInfo() {
        for (Integer id : getBooks().keySet()) {
            Book currentBook = books.get(id);
            if (currentBook.isAvailable()) {
                System.out.println(books.get(id));
            }
        }
        System.out.println();
    }
}
