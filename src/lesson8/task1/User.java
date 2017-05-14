package lesson8.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int readerCardNumber;
    private String surName;
    private String name;
    private String fatherName;
    private String faculty;
    private LocalDate birthDay;
    private String phoneNumber;
    private List<Book> takenBooks;
    private static int id;

    public User() {
        takenBooks = new ArrayList<>();
    }

    public User(String surName, String name, String fatherName, LocalDate birthDay) {
        this();
        this.surName = surName;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        id++;
    }

    public User(User user) {
        this.readerCardNumber = user.readerCardNumber;
        this.surName = user.surName;
        this.name = user.name;
        this.fatherName = user.fatherName;
        this.faculty = user.faculty;
        this.phoneNumber = user.phoneNumber;
        this.birthDay = user.birthDay;
    }

    public int getReaderCardNumber() {
        return readerCardNumber;
    }

    public void setReaderCardNumber(int readerCardNumber) {
        this.readerCardNumber = readerCardNumber;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static int getID() {
        return id;
    }

    public void takeBook(int id) {
        Book tryingBook = Librarian.getBook(id);
        if (tryingBook != null) {
            takenBooks.add(tryingBook);
        }
    }

    public void takeBook(String... booksNames) {
        for (String bookName : booksNames) {
            Book tryingBook = Librarian.getBook(bookName);
            if (tryingBook != null) {
                takenBooks.add(tryingBook);
            }
        }
    }

    public void takeBook(Book... books) {
        for (Book book : books) {
            Book tryingBook = Librarian.getBook(book);
            if (tryingBook != null) {
                takenBooks.add(tryingBook);
            }
        }
    }

    public void returnBook(String... bookNames) {
        Book currentBook = null;
        for (String bookName : bookNames) {
            for (Book book : takenBooks) {
                if (book.getBookName().equals(bookName)) {
                    currentBook = book;
                }
            }
            Librarian.returnBook(currentBook.getBookName());
            takenBooks.remove(currentBook);
        }
    }

    public void returnBook(Book... books) {
        for (Book book : books) {
            if (takenBooks.contains(book)) {
                Librarian.returnBook(book);
                takenBooks.remove(book);
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "readerCardNumber=" + readerCardNumber +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", birthDay=" + birthDay +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", takenBooks=" + takenBooks +
                '}';
    }
}
