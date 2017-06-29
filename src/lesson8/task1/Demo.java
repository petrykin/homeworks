package lesson8.task1;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Demo {
    public static int cardNumber = 10005;

    public static User getUser(Scanner scanner) {
        User user = new User();
        System.out.print("Введите ФИО нового читателя: ");
        String[] fio = scanner.nextLine().split(" ");
        user.setSurName(fio[0]);
        user.setName(fio[1]);
        user.setFatherName(fio[2]);

        System.out.print("Введите дату рождения в формате dd/mm/yyyy: ");
        String[] data = scanner.nextLine().split("/");
        user.setBirthDay(LocalDate.of(parseInt(data[2]), parseInt(data[1]), parseInt(data[0])));

        System.out.print("Введите название факультета: ");
        user.setFaculty(scanner.nextLine());

        System.out.print("Введите номер телефона: ");
        user.setPhoneNumber(scanner.nextLine());

        user.setReaderCardNumber(cardNumber++);
        return user;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsersDB usersDB = new UsersDB();
        BooksDB booksDB = new BooksDB();
        Librarian.setBooksDB(booksDB);

        usersDB.setUser(getUser(scanner));

        usersDB.printAllUsersInfo();
        booksDB.printAvailableBooksInfo();

        usersDB.getUser(10000).takeBook(new Book("Лао Цзы", "Искусство войны"));
        usersDB.getUser(10001).takeBook(new Book("Лао Цзы", "Искусство войны"), new Book("Тарас Шевченко", "Кобзар"));
        usersDB.getUser(10002).takeBook(5);
        usersDB.getUser(10003).takeBook("Приключения барона Мюнхгаузена", "Мифы и легенды Древней Греции");
        usersDB.getUser(10004).takeBook(5);

        usersDB.printAllUsersInfo();
        booksDB.printAvailableBooksInfo();

        usersDB.getUser(10002).returnBook("Бот");
        usersDB.getUser(10003).returnBook(new Book("Э. Распэ", "Приключения барона Мюнхгаузена"), new Book("А. Кун", "Мифы и легенды Древней Греции"));

        usersDB.printAllUsersInfo();
        booksDB.printAvailableBooksInfo();
    }
}
