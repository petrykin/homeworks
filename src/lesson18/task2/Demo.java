package lesson18.task2;

public class Demo {
    public static void main(String[] args) {
        User user = new User("admin", "admin");
        user.createQuery("SELECT * FROM users");
    }
}
