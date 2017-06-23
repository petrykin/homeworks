package lesson18.task1;

public class Demo {
    public static void main(String[] args) {
        User user = new User("admin", "admin");
        user.createQuery("SELECT * FROM users");
        user.new Query().printToLog("SELECT * FROM users WHERE 'id' = 1");
        new User("guest", "guest").new Query().printToLog("SELECT login FROM users WHERE 'id' = 1");
    }
}
