package lesson18.task3;

public class Demo {
    public static void main(String[] args) {
        User user = new User("admin", "admin");
        user.createQuery("SELECT * FROM users");
        new User.Query().printToLog(user, "SELECT * FROM users WHERE 'id' = 1");
        new User.Query().printToLog(new User("guest", "guest"), "SELECT login FROM users WHERE 'id' = 1");
    }
}
