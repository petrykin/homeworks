package lesson8.task1;

public class Book {
    private String author;
    private String bookName;
    private boolean isAvailable;

    private static int bookCount;

    public Book() {
        this("Unknown author", "Unknown book");
    }

    public Book(String author, String bookName) {
        this.author = author;
        this.bookName = bookName;
        isAvailable = true;
        bookCount++;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public static int getBookCount() {
        return bookCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!author.equals(book.author)) return false;
        return bookName.equals(book.bookName);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + bookName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
