package lesson8.task1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UsersDB {
    private Map<Integer, User> users;
    private int availableCardNumber;

    public UsersDB() {
        users = new HashMap<>();
        User user = new User("Иванов", "Иван", "Иванович", LocalDate.of(1956, 6, 6));
        user.setFaculty("JV 17_01");
        user.setPhoneNumber("+38(000)111-11-11");
        user.setReaderCardNumber(10000);
        users.put(user.getReaderCardNumber(), user);

        user = new User("Петров", "Петр", "Петрович", LocalDate.of(1957, 7, 7));
        user.setFaculty("JV 17_02");
        user.setPhoneNumber("+38(000)222-22-22");
        user.setReaderCardNumber(10001);
        users.put(user.getReaderCardNumber(), user);

        user = new User("Сидоров", "Сидор", "Сидорович", LocalDate.of(1958, 8, 8));
        user.setFaculty("JV 17_03");
        user.setPhoneNumber("+38(000)333-33-33");
        user.setReaderCardNumber(10002);
        users.put(user.getReaderCardNumber(), user);

        user = new User("Никифоров", "Никифор", "Никифорович", LocalDate.of(1959, 9, 9));
        user.setFaculty("JV 17_04");
        user.setPhoneNumber("+38(000)444-44-44");
        user.setReaderCardNumber(10003);
        users.put(user.getReaderCardNumber(), user);

        user = new User("Игнатов", "Игнат", "Игнатович", LocalDate.of(1960, 10, 10));
        user.setFaculty("JV 17_05");
        user.setPhoneNumber("+38(000)555-55-55");
        user.setReaderCardNumber(10004);
        users.put(user.getReaderCardNumber(), user);

        availableCardNumber = user.getReaderCardNumber() + 1;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, User> users) {
        this.users = users;
    }

    public void setUser(User user) {
        users.put(user.getReaderCardNumber(), user);
        availableCardNumber++;
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public int getAvailableCardNumber() {
        return availableCardNumber;
    }

    public void printUserInfo(int id) {
        System.out.println(users.get(id));
    }

    public void printAllUsersInfo() {
        for (Integer id : getUsers().keySet()) {
            printUserInfo(id);
        }
        System.out.println();
    }
}
